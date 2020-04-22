package stepDef;
import cucumber.api.DataTable;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import logic.FirstTest;

import java.util.List;
import java.util.Map;

public class testStepDef {

    FirstTest firstTest = new FirstTest();
    String nameOfJson = null;

    @Когда("^выполнен POST запрос на URL \"([^\"]*)\" с параметрами из таблицы. Ожидается код ответа: (.*)$")
    public void sendRequest(String url, int code, DataTable arg){
        List<List<String>> table = arg.asLists(String.class);
        for (int i=0; i<table.size(); i++) {
            switch (table.get(i).get(0)){
                case ("BODY"):
                    nameOfJson = table.get(i).get(2);
                    break;
            }
        }
        firstTest.sendRequestAndCheckStatus(url, code, FirstTest.test(nameOfJson));
    }
}
