# language: ru
@test1

Функционал: проверка АПИ deleate

  Сценарий: тест
    Когда выполнен DELEATE запрос на URL "tasks". Ожидается код ответа: 200
      | HEADER | Authorization | Bearer 694e9a123386e3ee235bea79b50b68df5da41dbf |
      | PARAMS | myPAram1      | 45                                              |
