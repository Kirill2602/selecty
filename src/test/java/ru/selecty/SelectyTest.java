package ru.selecty;

import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.selecty.pages.MainPage;
import ru.selecty.testbase.TestBase;

public class SelectyTest extends TestBase {
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Check Main page text")
    @Step("1")
    public void checkMainPageText() {
        mainPage.checkMainPageText();
    }

    @Test
    @DisplayName("Check NavBar links text")
    @Step("2")
    public void checkNavBarLinksText() {
        mainPage.checkNavBarLinksText(getLinkText());
    }

    @Test
    @DisplayName("Check NavBar links text after click on EN language link")
    @Step("3")
    public void checkNavBarLinksTextAfterClickOnEnLanguageLink() {
        mainPage.clickEnLanguageLink().checkNavBarLinksText(getEnLanguageLinkText());
    }

    @Test
    @DisplayName("Check Selecty subMenu links")
    @Step("4")
    public void checkSelectySubMenuLinks() {
        mainPage.checkLinkSubMenu("Selecty", getNavBarSubMenuMap().get("Selecty"));
    }

    @Test
    @DisplayName("Check Services subMenu links")
    @Step("5")
    public void checkServicesSubMenuLinks() {
        mainPage.checkLinkSubMenu("Услуги", getNavBarSubMenuMap().get("Услуги"));
    }

    @Test
    @DisplayName("Check Career subMenu links")
    @Step("6")
    public void checkCareerSubMenuLinks() {
        mainPage.checkLinkSubMenu("Карьера", getNavBarSubMenuMap().get("Карьера"));
    }

    @Test
    @DisplayName("Check Selecty EN language SubMenu links")
    @Step("7")
    public void checkSelectyEnLanguageSubMenuLinks() {
        mainPage.clickEnLanguageLink().checkLinkSubMenu("Selecty", getEnLanguageNavBarSubMenuMap().get("Selecty"));
    }

    @Test
    @DisplayName("Check Services EN language subMenu links")
    @Step("8")
    public void checkServicesEnLanguageSubMenuLinks() {
        mainPage.clickEnLanguageLink().checkLinkSubMenu("Services", getEnLanguageNavBarSubMenuMap().get("Services"));
    }

    @Test
    @DisplayName("Check Career EN language SubMenu links")
    @Step("9")
    public void checkCareerEnLanguageSubMenuLinks() {
        mainPage.clickEnLanguageLink().checkLinkSubMenu("Career", getEnLanguageNavBarSubMenuMap().get("Career"));
    }

    @Test
    @DisplayName("Check social links href")
    @Step("10")
    public void checkSocialLinksHref() {
        mainPage.checkPartOfSocialLinksHref(getExpectedSocialLinks());
    }
}
