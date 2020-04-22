package logic;
import org.json.simple.JSONObject;
import org.json.JSONTokener;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import paths.Paths;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MainLogic {


    public static JSONObject takeJsonToSend(String jsonFileName) {
        File file = new File(Paths.pathToJsons() + jsonFileName + ".json");
        try {
            return (JSONObject) readJsonSimpleDemo(file);
        }
        catch (Exception ignored) {}
        return null;
    }

    private static Object readJsonSimpleDemo(File file) throws Exception {
        FileReader reader = new FileReader(file);
        JSONParser jsonParser = new JSONParser();
        return jsonParser.parse(reader);
    }

    public void sendPOSTRequestAndCheckStatus(String url, int code, JSONObject jsonObject) {
        given().log().headers().log().body()
                .header("Authorization", "Bearer 694e9a123386e3ee235bea79b50b68df5da41dbf")
                .contentType("application/json\r\n")
                .body(jsonObject.toString())
                .when().post(url)
                .then().log().body()
                .statusCode(code);
    }

    public void sendGETRequestAndCheckStatus(String url, int code, Map<String, ?> map) {
        given().log().all()
                .queryParams(map)
                .when().get(url)
                .then().log().body()
                .statusCode(code);
    }

}
