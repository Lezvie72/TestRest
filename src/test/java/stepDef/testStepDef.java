package stepDef;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import logic.FirstTest;

public class testStepDef {

//TODO: сделать передачу параметрами из сценария

    FirstTest firstTest = new FirstTest();

    @Когда("^выполнен POST запрос на URL \"([^\"]*)\". Ожидается код ответа: (\\d+)$")
    public void sendRequest(String url, int code){
        firstTest.sendRequestAndCheckStatus(url, code, firstTest.createInCorrectJSON("MyTest", "tomorrow at 12:00", "en", 4));
    }

    @Когда("^выполнен POST запрос на URL \"([^\"]*)\" с параметрами. Ожидается код ответа: (\\d+)$")
    public void sendRequestWithParam(String url, int code){
        firstTest.sendRequestAndCheckStatus(url, code, firstTest.createInCorrectJSON("MyTest", "tomorrow at 12:00", "en", "4"));
    }

    @Когда("^выполнен POST запрос на URL \"([^\"]*)\" с одним отсутствующим параметром. Ожидается код ответа: (\\d+)$")
    public void sendRequestWithoutParam(String url, int code){
        firstTest.sendRequestAndCheckStatus(url, code, firstTest.createInCorrectJSON("", "tomorrow at 12:00", "en", 4));
    }

    @Когда("^выполнен POST запрос на URL \"([^\"]*)\" без токена. Ожидается код ответа: (\\d+)$")
    public void sendRequestWithoutToken(String url, int code){
        firstTest.sendRequestWithotToken(url, code, firstTest.createInCorrectJSON("MyTest", "tomorrow at 12:00", "en", 4));
    }

}
