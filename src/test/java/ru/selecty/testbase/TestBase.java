package ru.selecty.testbase;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.selecty.config.ProjectConfig;
import ru.selecty.helpers.Attach;
import ru.selecty.pages.MainPage;
import ru.selecty.testdata.TestData;

public class TestBase extends TestData {
    private static final ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());

    @BeforeAll
    public static void setUp() {
        if (!config.getIsRemote()) {
            Configuration.baseUrl = config.getBaseUrl();
            Configuration.browserSize = config.getBrowserSize();
        } else {
            Configuration.baseUrl = config.getBaseUrl();
            Configuration.remote = config.getRemote();
            Configuration.browser = config.getBrowser();
            Configuration.browserSize = config.getBrowserSize();
            Configuration.timeout = config.getTimeout();
            Configuration.browserVersion = config.getBrowserVersion();
//            Configuration.baseUrl = System.getProperty("baseUrl", "https://selecty.ru/");
//            Configuration.remote = System.getProperty("remoteUrl", "https://" + System.getProperty("login") + ":" + System.getProperty("password") + "@" + System.getProperty("remoteDriverUrl")) + "/wd/hub";
//            Configuration.browser = System.getProperty("browser", "chrome");
//            Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
//            Configuration.timeout = Long.parseLong(System.getProperty("timeout", "6000"));
//            Configuration.browserVersion = System.getProperty("browserVersion", "100");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }

    @BeforeEach
    public void addLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        new MainPage().openPage();
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