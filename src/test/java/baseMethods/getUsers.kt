package baseMethods

import api.consts.Instance.main_app_url
import io.restassured.RestAssured.given
import io.restassured.response.ValidatableResponse


fun getListOfUsersByPageIdApiGetExecuteMethod(pageId: Int)
        : ValidatableResponse {
    return given()
               .header("Authorization", "Bearer 694e9a123386e3ee235bea79b50b68df5da41dbf")
               .contentType("application/json").
          `when`()
                 .queryParam("page", pageId)
                 .get("$main_app_url/api/users").
           then()
                 .log().ifError()

}