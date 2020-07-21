package stepDef

import baseMethods.getListOfUserByPageIdGetExecuteMethod
import cucumber.api.java.ru.Когда

class getUsersStepDef {

    @Когда("Выполнен GET запрос что бы посмотреть всех пользователей")
    fun getListOfUsers() {
        getListOfUserByPageIdGetExecuteMethod(
                pageId = 2
        )
                .statusCode(200)
                .log().body()
    }

}