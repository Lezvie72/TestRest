# language: ru
@test

Функционал: проверка АПИ deleate

  Структура сценария: тест
    Когда выполнен DELETE запрос на URL "tasks" с параметром из таблицы. Ожидается код ответа: 204
      | HEADER | Authorization | Bearer 694e9a123386e3ee235bea79b50b68df5da41dbf |
      | DELETE |               | <id>                                      |
    Примеры:
    |id|
    |3832727169|
    |3833614074|
    |3833645853|
    |3833660054|
    |3833674015|
    |3833674029|
    |3833685831|
    |3833674045|
    |3833692263|
    |3833692896|
    |3833693427|
    |3833701370|
    |3833701407|


