package stepDef;

import cucumber.api.DataTable;
import cucumber.api.java.ru.Когда;
import logic.MainLogic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testStepDef {

    MainLogic mainLogic = new MainLogic();
    String nameOfJson = null;
    Map<String, String> headers = new HashMap<>();
    Map<String, Object> params = new HashMap<>();
    String endPointForDelete = null;

    private void prepareData(List<List<String>> table) {
        for (List<String> strings : table) {
            switch (strings.get(0)) {
                case ("BODY"):
                    nameOfJson = strings.get(2);
                    break;
                case ("PARAMS"):
                    params.put(strings.get(1), strings.get(2));
                    break;
                case ("HEADER"):
                    headers.put(strings.get(1), strings.get(2));
                    break;
                case ("DELETE"):
                    endPointForDelete = strings.get(2);
            }
        }
    }

    @Когда("^выполнен POST запрос на URL \"([^\"]*)\" с параметрами из таблицы. Ожидается код ответа: (.*)$")
    public void sendPOSTRequest(String url, int code, DataTable arg) {
        List<List<String>> table = arg.asLists(String.class);
        prepareData(table);
        mainLogic.sendPOSTRequestAndCheckStatus(url, code, MainLogic.takeJsonToSend(nameOfJson));
    }

    @Когда("^выполнен DELETE запрос на URL \"([^\"]*)\" с параметром из таблицы. Ожидается код ответа: (.*)$")
    public void sendDELEATERequest(String url, int code, DataTable arg) {
        List<List<String>> table = arg.asLists(String.class);
        prepareData(table);
        mainLogic.sendDELEATERequestAndCheckStatus(url, code, params, headers, endPointForDelete);
    }

    @Когда("^выполнен GET запрос на URL \"([^\"]*)\" с параметрами из таблицы. Ожидается код ответа: (.*)$")
    public void sendGETRequest(String url, int code, DataTable arg) {
        List<List<String>> table = arg.asLists(String.class);
        prepareData(table);
        mainLogic.sendGETRequestWithParamAndCheckStatus(url, code, params, headers);
    }

    @Когда("^выполнен GET запрос на URL \"([^\"]*)\". Ожидается код ответа: (.*)$")
    public void sendGETRequest(String url, int code) {
        mainLogic.sendGETRequestAndCheckStatus(url, code);
    }
}
