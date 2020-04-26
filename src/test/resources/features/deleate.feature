# language: ru
@test1

Функционал: проверка АПИ deleate

  Сценарий: тест
    Когда выполнен DELEATE запрос на URL "tasks" с параметрами из таблицы. Ожидается код ответа: 200
      | BODY   |           | myJson |
      | PARAMS | myPAram1  | 45     |
      | PARAMS | myPAram2  | 11     |
      | HEADER | myHeader1 | 22     |
      | HEADER | myHeader2 | 33     |