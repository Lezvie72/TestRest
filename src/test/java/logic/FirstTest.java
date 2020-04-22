package logic;
import org.json.simple.JSONObject;
import org.json.JSONTokener;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class FirstTest {


    public static JSONObject test(String jsonFileName) {
        String baseDir = System.getProperty("user.dir");
        String jsonDir = baseDir + "/src/test/java/jsons/";
        File file = new File(jsonDir + jsonFileName + ".json");
        try {
            return (JSONObject) readJsonSimpleDemo(file);
        }
        catch (Exception ignored) {

        }
        return null;
    }

    public static Object readJsonSimpleDemo(File file) throws Exception {
        file.createNewFile();
        FileReader reader = new FileReader(file);
        JSONParser jsonParser = new JSONParser();
        return jsonParser.parse(reader);
    }

    public void sendRequestAndCheckStatus(String url, int code, JSONObject jsonObject) {
        given().log().headers().log().body()
                .header("Authorization", "Bearer 694e9a123386e3ee235bea79b50b68df5da41dbf")
                .contentType("application/json\r\n")
                .body(jsonObject.toString())
                .when().post(url)
                .then().log().body()
                .statusCode(code);
    }

    public void sendRequestWithotToken(String url, int code, JSONObject jsonObject) {
        given().log().headers().log().body()
                .contentType("application/json\r\n")
                .body(jsonObject.toString())
                .when().post(url)
                .then().log().body()
                .statusCode(code);
    }

}
