package stepDef

import baseMethods.createUserApiPostExecuteMethod
import cucumber.api.java.ru.Когда
import fixtures.CreateUserFixture
import org.apache.http.HttpStatus
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.notNullValue

class CreateUserStepDef {

    @Когда("Выполнен POST запрос на здание нового пользователя")
    fun createNewUser() {
        val requestBody = CreateUserFixture().requestBody
        createUserApiPostExecuteMethod(
                requestPayload = requestBody
        )
                .statusCode(HttpStatus.SC_CREATED)
                .body(
                        "id", notNullValue(),
                        "email", equalTo("michael.lawson@reqres.in"),
                        "first_name", equalTo("Michael"),
                        "last_name", equalTo("Lawson"),
                        "avatar", equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg"),
                        "createdAt", notNullValue())
    }
}