package stepDef

import baseMethods.getListOfUsersByPageIdApiGetExecuteMethod
import cucumber.api.java.ru.Когда
import org.apache.http.HttpStatus
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.notNullValue

class GetListOfUsersByPageId {

    @Когда("Выполнен GET запрос на получения всех пользовтелей на старице (.*)")
    fun getUser(pageId: Int) {
        getListOfUsersByPageIdApiGetExecuteMethod(
                pageId = pageId
        )
                .statusCode(HttpStatus.SC_OK)
                .body(
                        "page", equalTo(2),
                        "per_page", equalTo( 6),
                        "total", equalTo( 12),
                        "total_pages", equalTo( 2),
                        "data.id", notNullValue(),
                        "data.email", notNullValue(),
                        "data.first_name", notNullValue(),
                        "data.last_name", notNullValue(),
                        "data.avatar", notNullValue())
    }
}
