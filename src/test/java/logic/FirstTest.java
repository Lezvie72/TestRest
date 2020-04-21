package logic;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;

public class FirstTest {


    public JSONObject createInCorrectJSON(Object content, Object due_date, Object due_lang, Object priority) {
        JSONObject json = new JSONObject();
        json.put("content", content);
        json.put("due_string", due_date);
        json.put("due_lang", due_lang);
        json.put("priority", priority);
        return json;
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

}
