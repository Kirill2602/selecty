package ru.selecty.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
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


    public void openPage() {
        step("Открыть главную страницу", () -> {
            open("/");
        });
        step("Проверить, что стартовая анимация закончилась", () -> {
            startedAnimationRu.shouldHave(attribute("style", "display: none;"));
        });
    }

    public MainPage checkMainPageText() {
        step("Проверить видимость блока с текстом 'ЦИФРОВАЯ ТРАНСФОРМАЦИЯ ПОД КЛЮЧ'", () -> {
            mainPageText.shouldBe(visible);
        });
        return this;
    }

    public MainPage checkNavBarLinksText(List<String> linksText) {
        step(String.format("Проверить текст ссылок %s в навбаре", linksText), () -> {
            for (int i = 0; navBarList.size() > i; i++) {
                assertEquals(navBarList.get(i).getText(), linksText.get(i));
            }
        });
        return this;
    }

    public MainPage checkLinkSubMenu(String linkName, List<String> subMenuLinkList) {
        step(String.format("Навести мышку на ссылку %s в навбаре", linkName), () -> {
            navBarList.findBy(text(linkName)).hover();
        });
        step("Проверить, что первый элемент из выпадающего списка отобразился", () -> {
            visibleMenu.get(0).shouldBe(visible);
        });
        step(String.format("Проверить актуальность всего выпадающего списка %s", subMenuLinkList), () -> {
            for (int i = 0; i < visibleMenu.size(); i++) {
                assertEquals(visibleMenu.get(i).getText(), subMenuLinkList.get(i));
            }
        });
        return this;
    }

    public MainPage checkPartOfSocialLinksHref(List<String> expectedResults) {
        step(String.format("Проверить наличие ссылок на социальные сети компании %s", expectedResults), () -> {
            for (int i = 0; i < socialLinks.size(); i++) {
                assertEquals(expectedResults.get(i), socialLinks.get(i).getAttribute("href"));
            }
        });
        return this;
    }

    public MainPage clickEnLanguageLink() {
        step("Нажать кнопку EN, для переключения языка на английский", () -> {
            enLanguageLink.click();
        });
        step("Проверить, что стартовая анимация, после переключения языка на английский закончилась", () -> {
            startedAnimationEn.shouldHave(attribute("style", "display: none;"));
        });
        return this;
    }
}
