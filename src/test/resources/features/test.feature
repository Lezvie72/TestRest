# language: ru
@test

Функционал: проверка АПИ

  Структура сценария: : проверка запроса позитивный
    Когда выполнен POST запрос на URL "tasks" с параметрами из таблицы. Ожидается код ответа: <код ответа>
      | BODY |  | <json> |
    Примеры:
      | json          | код ответа |
      | inCorrectJson | 400        |
      | myJson        | 200        |

  Сценарий: тест
    Когда выполнен POST запрос на URL "tasks" с параметрами из таблицы. Ожидается код ответа: 200
      | BODY   |           | myJson |
      | PARAMS | myPAram1  | 45     |
      | PARAMS | myPAram2  | 11     |
      | HEADER | myHeader1 | 22     |
      | HEADER | myHeader2 | 33     |

  Структура сценария: : тестим GET
    Когда выполнен GET запрос на URL "https://petstore.swagger.io/v2/pet/findByStatus" с параметрами из таблицы. Ожидается код ответа: 200
      | PARAMS | status | <status> |
    Примеры:
      | status    |
      | available |
      | pending   |
      | sold      |






