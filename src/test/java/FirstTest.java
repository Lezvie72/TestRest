import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.when;
import static com.jayway.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.hasKey;

public class FirstTest {

    String id;

    public JSONObject myHero() {
        JSONObject hero = new JSONObject();
        hero.put("birthDate", "2019-02-21");
        hero.put("city", "LA");
        hero.put("fullName", "Robert Robertovich");
        hero.put("gender", "M");
        hero.put("id", id);
        hero.put("mainSkill", "trader");
        hero.put("phone", "+79995412202");
        return hero;
    }

    @Test
    public void getSuperHeroes() {
        when()
                .get("https://superhero.qa-test.csssr.com/superheroes")
                .then()
                .statusCode(200)
                .contentType("application/json");
        String resp = get("https://superhero.qa-test.csssr.com/superheroes").asString();
        List<String> ids = from(resp).getList("findAll {it}");
        int arrayLength = ids.size();
        Assert.assertTrue(arrayLength > 0);
        System.out.println(ids);
        System.out.println(arrayLength);
    }

    @Test
    public void createHero() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(myHero().toString());
        Response response = request.post("https://superhero.qa-test.csssr.com/superheroes");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        id = from(response.asString()).getString("id");
        System.out.println(id);
        System.out.println(response.getBody().asString());
    }

    @Test
    public void getSuperhero() {
        when()
                .get("https://superhero.qa-test.csssr.com/superheroes/" + id)
                .then()
                .body("$", hasKey("id"))
                .body("$", hasKey("fullName"))
                .body("$", hasKey("birthDate"))
                .body("$", hasKey("city"))
                .body("$", hasKey("mainSkill"))
                .body("$", hasKey("gender"))
                .body("$", hasKey("phone"));
    }

    @Test
    public void hDelUser() {
        when()
                .delete("https://superhero.qa-test.csssr.com/superheroes/" + id)
                .then()
                .statusCode(200);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testEx() throws AssertionError{
            getSuperhero();
    }
}
