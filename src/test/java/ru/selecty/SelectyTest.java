package ru.selecty;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.selecty.pages.MainPage;
import ru.selecty.testbase.TestBase;

public class SelectyTest extends TestBase {
    MainPage mainPage = new MainPage();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Check Main page text")
    @Step("Проверка текста на главной странице")
    public void checkMainPageText() {
        mainPage.checkMainPageText();
    }

    @Test
    @DisplayName("Check NavBar links text")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Проверка наличия необходимых ссылок в нав баре")
    public void checkNavBarLinksText() {
        mainPage.checkNavBarLinksText(getLinkText());
    }

    @Test
    @DisplayName("Check NavBar links text after click on EN language link")
    @Step("Проверка наличия необходимых ссылок в нав баре, после смены языка на английский")
    public void checkNavBarLinksTextAfterClickOnEnLanguageLink() {
        mainPage.clickEnLanguageLink().checkNavBarLinksText(getEnLanguageLinkText());
    }

    @Test
    @DisplayName("Check Selecty subMenu links")
    @Step("Проверка наличия всех необходимых пунктов в выпадающем списке 'Selecty'")
    public void checkSelectySubMenuLinks() {
        mainPage.checkLinkSubMenu("Selecty", getNavBarSubMenuMap().get("Selecty"));
    }

    @Test
    @DisplayName("Check Services subMenu links")
    @Step("Проверка наличия всех необходимых пунктов в выпадающем списке 'Услуги'")
    public void checkServicesSubMenuLinks() {
        mainPage.checkLinkSubMenu("Услуги", getNavBarSubMenuMap().get("Услуги"));
    }

    @Test
    @DisplayName("Check Career subMenu links")
    @Step("Проверка наличия всех необходимых пунктов в выпадающем списке 'Карьера'")
    public void checkCareerSubMenuLinks() {
        mainPage.checkLinkSubMenu("Карьера", getNavBarSubMenuMap().get("Карьера"));
    }

    @Test
    @DisplayName("Check Selecty EN language SubMenu links")
    @Step("Проверка наличия всех необходимых пунктов в выпадающем списке 'Selecty', после смены языка на английский")
    public void checkSelectyEnLanguageSubMenuLinks() {
        mainPage.clickEnLanguageLink().checkLinkSubMenu("Selecty", getEnLanguageNavBarSubMenuMap().get("Selecty"));
    }

    @Test
    @DisplayName("Check Services EN language subMenu links")
    @Step("Проверка наличия всех необходимых пунктов в выпадающем списке 'Services', после смены языка на английский")
    public void checkServicesEnLanguageSubMenuLinks() {
        mainPage.clickEnLanguageLink().checkLinkSubMenu("Services", getEnLanguageNavBarSubMenuMap().get("Services"));
    }

    @Test
    @DisplayName("Check Career EN language SubMenu links")
    @Step("Проверка наличия всех необходимых пунктов в выпадающем списке 'Career', после смены языка на английский")
    public void checkCareerEnLanguageSubMenuLinks() {
        mainPage.clickEnLanguageLink().checkLinkSubMenu("Career", getEnLanguageNavBarSubMenuMap().get("Career"));
    }

    @Test
    @DisplayName("Check social links href")
    @Step("Проверка наличия всех необходимых ссылок на социальные сети компании")
    public void checkSocialLinksHref() {
        mainPage.checkPartOfSocialLinksHref(getExpectedSocialLinks());
    }
}
