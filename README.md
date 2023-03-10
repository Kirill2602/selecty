<h1>Проект по автоматизации тестирования для Selecty</h1>

<div style="display: flex; flex-direction:column;">
<a target="_blank" href="https://www.selecty.ru/"><img src="images/selecty.jpg"></a>
</div>

## :pushpin: Содержание:
- [Технологии и инструменты](#tech)
- [Реализованные проверки](#checks)
- [Сборка в Jenkins](#job)
- [Запуск из терминала](#term)
- [Allure отчет](#allure)
- [Интеграция с Allure TestOps](#testOps)
- [Интеграция с Jira](#jira)
- [Отчет в Telegram](#tm)
- [Видео примеры прохождения тестов](#video)

## :rocket: Технологии и инструменты

| Intellij Idea                                                                                                                    | Java         | Github  | JUnit 5  | Gradle | Selenide | Selenoid | Allure | Jenkins |
|:---------------------------------------------------------------------------------------------------------------------------------|-------------| ----- | ----- | ----- | ----- | ----- | ----- | -----: |
| <a id ="tech" href="https://www.jetbrains.com/idea/"><img src="images/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a> | <a href="https://www.java.com/"><img src="images/Java.svg" width="50" height="50"  alt="Java"/></a>| <a href="https://github.com/"><img src="images/Github.svg" width="50" height="50"  alt="Github"/></a> | <a href="https://junit.org/junit5/"><img src="images/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a> | <a href="https://gradle.org/"><img src="images/Gradle.svg" width="50" height="50"  alt="Gradle"/></a> | <a href="https://selenide.org/"><img src="images/Selenide.svg" width="50" height="50"  alt="Selenide"/></a> | <a href="https://aerokube.com/selenoid/"><img src="images/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a> | <a href="https://github.com/allure-framework/allure2"><img src="images/Allure_Report.svg" width="50" height="50"  alt="Allure"/></a> | <a href="https://www.jenkins.io/"><img src="images/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>|

## :scroll: Реализованные проверки

<a id = "checks"></a>
- Проверка текста на главной странице.
- Проверка наличия необходимых ссылок в нав баре.
- Проверка наличия необходимых ссылок в нав баре, после смены языка на английский.
- Проверка наличия всех необходимых пунктов в выпадающем списке 'Selecty'.
- Проверка наличия всех необходимых пунктов в выпадающем списке 'Услуги'.
- Проверка наличия всех необходимых пунктов в выпадающем списке 'Карьера'.
- Проверка наличия всех необходимых пунктов в выпадающем списке 'Selecty', после смены языка на английский.
- Проверка наличия всех необходимых пунктов в выпадающем списке 'Services', после смены языка на английский.
- Проверка наличия всех необходимых пунктов в выпадающем списке 'Career', после смены языка на английский.
- Проверка наличия всех необходимых ссылок на социальные сети компании.

## <img src="images/Jenkins.svg" width="25" height="25"  alt="Jenkins"/> Jenkins job

<a id="job" target="_blank" href="https://jenkins.autotests.cloud/job/selecty_project/">Сборка в Jenkins</a>
<div align="center">
<a href="https://jenkins.autotests.cloud/job/selecty_project/"><img src="images/jenkins_job.png" alt="Jenkins"/></a>
</div>

### Параметры сборки в Jenkins:

- browser (браузер, по умолчанию chrome)
- browserVersion (версия браузера, по умолчанию 100.0)
- browserSize (размер окна браузера, по умолчанию 1920x1080)
- baseUrl (https://selecty.ru/)
- remoteDriverUrl (selenoid.autotests.cloud)
- timeout (4000)
- remoteUrl (https://${LOGIN}:${PASSWORD}@${REMOTE_DRIVER_URL})
- login
- password

## :computer: Запуск тестов из терминала

Локальный запуск:
<a id="term"></a>
```bash
gradle clean test
```

Удаленный запуск:

```bash
clean
test
"-DremoteUrl=https://${LOGIN}:${PASSWORD}@${REMOTE_DRIVER_URL}/wd/hub"
"-DbrowserSize=${BROWSER_SIZE}"
"-DbrowserVersion=${BROWSER_VERSION}"
"-Dbrowser=${BROWSER}"
"-DbaseUrl=${BASE_URL}"
```

## <img id="allure" src="images/Allure_Report.svg" width="25" height="25"  alt="Allure"/> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/selecty_project/9/allure/">Allure report</a>

### Основное окно

<div align="center">
<img title="Allure Overview Dashboard" src="images/allure_report.png">
</div>

### Тесты

<div align="center">
<img title="Allure Tests" src="images/allure_test_new.png">
</div>

### Графики

<div align="center">
<img title="Allure Graphics" src="images/allure_graphs.png">
</div>

## <img src="images/Allure_EE.svg" width="25" height="25"  alt="Allure"/></a>Интеграция с <a target="_blank" href="https://allure.autotests.cloud/launch/18237">Allure TestOps</a>

### Дашборд

<div align="center">
<img id="testOps" title="Allure TestOps Dashboard" src="images/testOps.png">
</div>

### Тест-кейсы

<div align="center">
<img title="Allure TestOps Tests" src="images/new_cases.png">
</div>

## <img src="images/Jira.svg" width="25" height="25"  alt="Allure"/></a>Интеграция с трекером задач <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-498">Jira</a>

<div align="center">
<img id="jira" title="Jira" src="images/jira.png">
</div>

## <img src="images/Telegram.svg" width="25" height="25"  alt="Allure"/></a> Уведомление в Telegram при помощи бота

<div align="center">
<img id="tm" title="Allure Overview Dashboard" src="images/tm.png">
</div>

### <img src="images/Selenoid.svg" width="25" height="25"  alt="Allure"/></a> Примеры видео о прохождении тестов

<div id="video" align="center">
<video src="https://user-images.githubusercontent.com/59203915/212070784-8b04f9f5-3d3d-4d86-90bb-f958c8455fc4.mp4"></video>
<video src="https://user-images.githubusercontent.com/59203915/212070789-7ac73637-9758-47e6-9819-626f311a50d6.mp4"></video>
</div>
