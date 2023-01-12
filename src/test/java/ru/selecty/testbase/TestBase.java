package ru.selecty.testbase;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.selecty.helpers.Attach;
import ru.selecty.pages.MainPage;
import ru.selecty.testdata.TestData;

public class TestBase extends TestData {
    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = System.getProperty("baseUrl", "https://selecty.ru/");
        Configuration.remote = System.getProperty("remoteUrl", "https://" + System.getProperty("login") + ":" + System.getProperty("password") + "@" + System.getProperty("remoteDriverUrl")) + "/wd/hub";
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.timeout = Long.parseLong(System.getProperty("timeout", "6000"));
        Configuration.browserVersion = System.getProperty("browserVersion", "100");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    public void addLogger() {
        new MainPage().openPage();
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    public void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}