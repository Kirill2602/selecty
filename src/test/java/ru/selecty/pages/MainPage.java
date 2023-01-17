package ru.selecty.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage {
    SelenideElement
            mainPageText = $x("//div[@class='tn-atom' and contains(text(), 'ЦИФРОВАЯ')]"),
            ruLanguageLink = $x("//a[text()='RU']"),
            startedAnimationRu = $("#rec424911473"),
            startedAnimationEn = $("#rec446218155"),
            enLanguageLink = $x("//a[text()='EN']");
    ElementsCollection
            navBarList = $$(".t228__centerside.t228__menualign_left .t228__list .t228__list_item .t-menu__link-item"),
            visibleMenu = $(".t-menusub__target-link_active").parent().$$(".t-menusub__list a"),
            socialLinks = $$(".t-sociallinks__wrapper a");


    @Step("Открыть главную страницу")
    public void openPage() {
        open("/");
        startedAnimationRu.shouldHave(attribute("style", "display: none;"));
    }

    @Step("Проверить видимость блока с текстом 'ЦИФРОВАЯ ТРАНСФОРМАЦИЯ ПОД КЛЮЧ'")
    public MainPage checkMainPageText() {
        mainPageText.shouldBe(visible);
        return this;
    }

    @Step("Проверить текст ссылок в навбаре")
    public MainPage checkNavBarLinksText(List<String> linksText) {
        for (int i = 0; navBarList.size() > i; i++) {
            assertEquals(navBarList.get(i).getText(), linksText.get(i));
        }
        return this;
    }

    @Step("Проверить содержание выпадающего меню")
    public MainPage checkLinkSubMenu(String linkName, List<String> subMenuLinkList) {
        navBarList.findBy(text(linkName)).hover();
        visibleMenu.get(0).shouldBe(visible);
        for (int i = 0; i < visibleMenu.size(); i++) {
            assertEquals(visibleMenu.get(i).getText(), subMenuLinkList.get(i));
        }
        return this;
    }

    @Step("Проверить наличие ссылок на социальные сети компании")
    public MainPage checkPartOfSocialLinksHref(List<String> expectedResults) {
        for (int i = 0; i < socialLinks.size(); i++) {
            assertEquals(expectedResults.get(i), socialLinks.get(i).getAttribute("href"));
        }
        return this;
    }

    @Step("Переключить страницу на английский язык")
    public MainPage clickEnLanguageLink() {
        enLanguageLink.click();
        startedAnimationEn.shouldHave(attribute("style", "display: none;"));
        return this;
    }
}
