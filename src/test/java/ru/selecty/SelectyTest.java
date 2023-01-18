package ru.selecty;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.selecty.pages.MainPage;
import ru.selecty.testbase.TestBase;

public class SelectyTest extends TestBase {
    MainPage mainPage = new MainPage();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Check Main page text")
    public void checkMainPageText() {
        mainPage.checkMainPageText();
    }

    @Test
    @DisplayName("Check NavBar links text")
    @Severity(SeverityLevel.CRITICAL)
    public void checkNavBarLinksText() {
        mainPage.checkNavBarLinksText(getLinkText());
    }

    @Test
    @DisplayName("Check NavBar links text after click on EN language link")
    public void checkNavBarLinksTextAfterClickOnEnLanguageLink() {
        mainPage.clickEnLanguageLink().checkNavBarLinksText(getEnLanguageLinkText());
    }

    @Test
    @DisplayName("Check Selecty subMenu links")
    public void checkSelectySubMenuLinks() {
        mainPage.checkLinkSubMenu("Selecty", getNavBarSubMenuMap().get("Selecty"));
    }

    @Test
    @DisplayName("Check Services subMenu links")
    public void checkServicesSubMenuLinks() {
        mainPage.checkLinkSubMenu("Услуги", getNavBarSubMenuMap().get("Услуги"));
    }

    @Test
    @DisplayName("Check Career subMenu links")
    public void checkCareerSubMenuLinks() {
        mainPage.checkLinkSubMenu("Карьера", getNavBarSubMenuMap().get("Карьера"));
    }

    @Test
    @DisplayName("Check Selecty EN language SubMenu links")
    public void checkSelectyEnLanguageSubMenuLinks() {
        mainPage.clickEnLanguageLink().checkLinkSubMenu("Selecty", getEnLanguageNavBarSubMenuMap().get("Selecty"));
    }

    @Test
    @DisplayName("Check Services EN language subMenu links")
    public void checkServicesEnLanguageSubMenuLinks() {
        mainPage.clickEnLanguageLink().checkLinkSubMenu("Services", getEnLanguageNavBarSubMenuMap().get("Services"));
    }

    @Test
    @DisplayName("Check Career EN language SubMenu links")
    public void checkCareerEnLanguageSubMenuLinks() {
        mainPage.clickEnLanguageLink().checkLinkSubMenu("Career", getEnLanguageNavBarSubMenuMap().get("Career"));
    }

    @Test
    @DisplayName("Check social links href")
    public void checkSocialLinksHref() {
        mainPage.checkPartOfSocialLinksHref(getExpectedSocialLinks());
    }
}
