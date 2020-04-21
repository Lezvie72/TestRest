# language: ru
@test

Функционал: проверка АПИ

  Сценарий: проверка запроса позитивный
    Когда выполнен POST запрос на URL "https://api.todoist.com/rest/v1/tasks". Ожидается код ответа: 200

  Сценарий: проверка запроса негативный
    Когда выполнен POST запрос на URL "https://api.todoist.com/rest/v1/tasks" с параметрами. Ожидается код ответа: 400

  Сценарий: проверка запроса негативный
    Когда выполнен POST запрос на URL "https://api.todoist.com/rest/v1/tasks" с одним отсутствующим параметром. Ожидается код ответа: 400
