# Требования
* Intellij Idea
* JDK
* Maven
* git

#Установка
##Установка необходимых компонентов
* ###Установка Intellij Idea
 * ####для windows 10  
 1. перейти по ссылке https://www.jetbrains.com/idea/download/#section=windows  
 2. скачать .exe файл (community edition будет достаточно)  
 3. установить программу  
 
 * ####для linux (ubuntu)  
 1.  найти Intellij Idea в "магазине приложений"  
 2. установить программу
    
* ###Установка JDK
 * ####для windows 10  
 1. перейти по ссылке https://www.oracle.com/java/technologies/javase-downloads.html  
 2. кликнуть ссылку JDK Download для последней доступной версии продукта  
 3. на открывшейся странице найти Windows x64 Installer и закгрузить его
 4. установить программу
 
 * ####для linux (ubuntu)  
 1. https://linuxize.com/post/install-java-on-ubuntu-18-04/
 
 * ###Установка Maven
 * ####для windows 10  
 1. перейти по ссылке https://maven.apache.org/download.cgi
 2. скачать bin.zip файл
 3. распоковать архив в удобную директорию, например C:\opt\apache-maven-3.6.3
 
 * ####для linux (ubuntu) - можно пропустить 
 1. https://linuxize.com/post/how-to-install-apache-maven-on-ubuntu-18-04/
    
 * ###Установка git
  * ####для windows 10 
 1. перейти по ссылке https://git-scm.com/download/win
 2. скачать 64-bit Git for Windows Setup
 3. установить как любую другую программу
    
  * ####для linux (ubuntu)
 1. в терминале выполнить команду  
     `sudo apt install git`
     
##Настройка системы
 * ###Настройка переменных окружения
  * ####для windows 10  
  1. в поиске пишем "environment variables" и открываем предложенный вариант
  2. в открывшемся системном окне нажимаем кнопку "environment variables"
  3. в открывшемся системном окне, в блоке "System variables" системные переменные со следующими значениями  
    `переменная - MAVEN_HOME, значение - C:\opt\apache-maven-3.6.3`  (либо путь по куда вы распоковали файлы мавена)  
    `переменная - TESTING_HOST, значение - develop-XX.vuaro.ru` где XX это номер вашего тестового стенда
  4. редактируем переменную Path  
    добавляем строку `C:\Program Files\Java\jdk-14\bin` в которой указан путь к директории bin для установленой jdk, перемещаем строку наверх списка  
    добавляем строку `%MAVEN_HOME%\bin`
    
  * ####для linux (ubuntu)
  1. если внимательно следовали инструкция по установке JDK и Maven, то основные переменные окружений уже добавлены, по аналогии добавляем только TESTING_HOST develop-XX.vuaro.ru   
     _Например:_  
     `#echo "export TESTING_HOST=develop-xx.vuaro.ru" >> /etc/environment && source /etc/environment`  
     _(Может потребоваться перезагрузка.)_
    
##Колонирование прокта и запуск тестов
 * ###Клонирование проекта  
  1. в терминале создать директорию (_ui - пример_)  
    `$ mkdir ui` 
  2. перейти в директорию  
    `$ mkdir ui`  
  3. выполнить команду  
    `$ git clone git@git.vuaro.ru:unicom/autotests.git`  
  4. перейти в директорию тестов  
    `$ cd frontend/`
  5. убедиться что все правильно  
    `$ git status`  
    должно быть так:  
    `On branch master  
    Your branch is up to date with 'origin/master'.  
    nothing to commit, working tree clean`  

или склонировать проект любым другим удобным способом  
 * ###Запуск тестов  
  1. запустить IDE  
  2. открыть папку проекта unicom24 в среде разработки **(не корневую папку проекта, а именно unicom24 !)**  
  3. при первом открытии проекта в среде разработки справа внизу появится всплывающее окно в котором обязательно нужно нажать **"enable auto import"**  
  4. заходим в меню _File > Settings > Plugin_, находим **Cucumber** и нажимаем _Install_, затем _ОК_ и перезапускаем среду разработки  
  5. проверяем, что плагин **Gherkin** установлен (_File > Settings > Plugin_)  
  6. после этого подтягиваем зависимости проекта, чтобы импортируемые библиотеки работали: находим файл **pom.xml** > кликаем на него правой кнопкой мыши _Maven > Reimport_  
  _(Если пункта Maven нет нужно вернуться к его установке и установить!)_  
  7. собираем проект с помощью зеленого молоточка 
  8. конфигурируем раннер _(рядом с молоточком)_  
      Шаблон: **Junit**  
      Class: **runners.TestFirstRunner**  
      Use classpath of module: **UNICOM24**  
  9. далее находим класс **TestFirstRunner.java** _(UNICOM24 > src > tests > java > runners > TestFirstRunner)_
  10. запускаем тесты кликнув правой кнопкой мыши по файлу **TestFirstRunner** и выбрав _"Run TestFirstRunner"_
 
* ###Варианты запуска тестов
  1. Кликнув на **TestFirstRunner** правой кнопкой мышки и выбрав _“Run TestFirstRunner“_ в левом окне _Project Explorer_  
  2. Выбрав _Run > Run ‘TestFirstRunner’_ из верхнего меню  
  3. Кликнув зелёный треугольничек в правом верхнем углу IDE  
  4. Можно запускать не все автотесты, а каждый автотест по отдельности. Для этого надо проставить автотест в _tags_ и запустить **TestFirstRunner**.  
  Список тегов есть на странице: https://unicom24.atlassian.net/wiki/spaces/QA/pages/424968510  
 
Полезная статья на хабре: https://habr.com/ru/post/332754/   