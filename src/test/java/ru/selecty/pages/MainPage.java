package ru.selecty.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPage {
    SelenideElement
            mainPageText = $x("//div[@class='tn-atom' and contains(text(), 'ЦИФРОВАЯ')]"),
            ruLanguageLink = $x("//a[text()='RU']"),
            enLanguageLink = $x("//a[text()='EN']");
    ElementsCollection
            navBarList = $$(".t228__centerside.t228__menualign_left .t228__list .t228__list_item .t-menu__link-item"),
            visibleMenu = $(".t-menusub__target-link_active").parent().$$(".t-menusub__list a"),
            socialLinks = $$(".t-sociallinks__wrapper a");


    public void openPage() {
        open("/");
    }

    public MainPage checkMainPageText() {
        mainPageText.shouldBe(visible);
        return this;
    }

    public MainPage checkNavBarLinksText(List<String> linksText) {
        for (int i = 0; navBarList.size() > i; i++) {
            assertEquals(navBarList.get(i).getText(), linksText.get(i));
        }
        return this;
    }

    public MainPage checkLinkSubMenu(String linkName, List<String> subMenuLinkList) {
        sleep(4000);
        navBarList.findBy(text(linkName)).hover();
        for (int i = 0; i < visibleMenu.size(); i++) {
            assertEquals(visibleMenu.get(i).getText(), subMenuLinkList.get(i));
        }
        return this;
    }

    public MainPage checkPartOfSocialLinksHref(List<String> expectedResults) {
        for (int i = 0; i < socialLinks.size(); i++) {
            assertEquals(expectedResults.get(i), socialLinks.get(i).getAttribute("href"));
        }
        return this;
    }

    public MainPage clickEnLanguageLink() {
        enLanguageLink.click();
        return this;
    }
}
