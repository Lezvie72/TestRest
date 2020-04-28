package logic;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import paths.Paths;

import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class MainLogic {

    public static JSONObject takeJsonToSend(String jsonFileName) {
        File file = new File(Paths.pathToJsons() + jsonFileName + ".json");
        try {
            return (JSONObject) readJsonSimpleDemo(file);
        } catch (Exception ignored) {
        }
        return null;
    }

    private String urlValue(String endPoint) {
        if (endPoint.startsWith("http"))
            return endPoint;
        Properties PROPERTIES = Paths.getPropertiesInstance();
        if (PROPERTIES.getProperty(endPoint).startsWith("http"))
            return PROPERTIES.getProperty(endPoint);
        return PROPERTIES.getProperty("baseURI") + PROPERTIES.getProperty(endPoint);
    }

    private static Object readJsonSimpleDemo(File file) throws Exception {
        FileReader reader = new FileReader(file);
        JSONParser jsonParser = new JSONParser();
        return jsonParser.parse(reader);
    }

    public void sendPOSTRequestAndCheckStatus(String url, int code, JSONObject jsonObject) {
        String urlValue = urlValue(url);
        RequestSpecification requestSpecification =
                given().log().headers().log().body()
                        .header("Authorization", "Bearer 694e9a123386e3ee235bea79b50b68df5da41dbf")
                        .contentType("application/json\r\n")
                        .body(jsonObject.toString());
        Response response =
                requestSpecification.when().post(urlValue);

        response.then().log().body()
                .statusCode(code);
    }

    public void sendDELEATERequestAndCheckStatus(String url,
                                                 int code,
                                                 Map<String, ?> map,
                                                 Map<String, ?> header,
                                                 String delete) {
        String urlValue = urlValue(url);
        RequestSpecification requestSpecification =
                given().log().all()
                        .headers(header)
                        .queryParams(map)
                        .contentType("application/json\r\n");
        Response response =
                requestSpecification.when().delete(urlValue + "/" +delete);

        response.then().log().body()
                .statusCode(code);
    }

    public void sendGETRequestWithParamAndCheckStatus(String url, int code, Map<String, ?> map, Map<String, ?> header) {
        String urlValue = urlValue(url);
        RequestSpecification requestSpecification =
                given().log().all()
                        .queryParams(map)
                        .headers(header);
        Response response =
                requestSpecification.when().get(urlValue);

        response.then().log().body()
                .statusCode(code);
        //response.then().assertThat().body(matchesJsonSchema(Paths.pathToJsons() + "forCheckResponses" + "findByStatus.json"));
        //matchesJsonSchemaInClasspath("findByStatus.json"));
    }

    public void sendGETRequestAndCheckStatus(String url, int code) {
        String urlValue = urlValue(url);
        RequestSpecification requestSpecification =
                given().log().all();
        Response response =
                requestSpecification.when().get(urlValue);

        response.then().log().body()
                .statusCode(code);
        //response.then().assertThat().body(matchesJsonSchema(Paths.pathToJsons() + "forCheckResponses" + "findByStatus.json"));
        //matchesJsonSchemaInClasspath("findByStatus.json"));
    }

}
