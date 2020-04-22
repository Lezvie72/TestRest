# language: ru
@test

Функционал: проверка АПИ

  Структура сценария: : проверка запроса позитивный
    Когда выполнен POST запрос на URL "https://api.todoist.com/rest/v1/tasks" с параметрами из таблицы. Ожидается код ответа: <код ответа>
      | BODY |  | <json> |
    Примеры:
      | json          | код ответа |
      | inCorrectJson | 400        |
      | myJson        | 200        |

  Сценарий: тест
  Когда выполнен POST запрос на URL "https://api.todoist.com/rest/v1/tasks" с параметрами из таблицы. Ожидается код ответа: 200
    | BODY |  | myJson |

