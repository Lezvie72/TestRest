package baseMethods

import api.consts.Instance.main_app_url
import io.restassured.RestAssured.given
import io.restassured.response.ValidatableResponse

fun getListOfUserByPageIdGetExecuteMethod(pageId: Int)
        : ValidatableResponse {
    return given()
                 .contentType("application/json").
           `when`()
                  .queryParam("page", pageId)
                  .get("$main_app_url/api/users").
           then()
                  .log().ifError()
}