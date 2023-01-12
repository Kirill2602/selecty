package ru.selecty.testdata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestData {
    private List<String> linkText = List.of("Selecty", "Услуги", "Карьера", "Контакты"),
            enLanguageLinkText = List.of("Selecty", "Services", "Career", "Contacts"),
            expectedSocialLinks = List.of("https://twitter.com/Selecty_IT", "https://vk.com/selecty1", "https://www.linkedin.com/company/selecty-hr/", "https://t.me/selecty_inside");

    private Map<String, List<String>> navBarSubMenuMap = new HashMap<>(
            Map.of("Selecty", List.of("О компании", "Новости", "СМИ о нас", "Мероприятия", "Глоссарий", "Блог"),
                    "Услуги", List.of("Аутсорсинг", "Рекрутмент", "Разработка ПО", "Профессиональный подбор"),
                    "Карьера", List.of("Работа в ИТ", "Работа в HR", "Тренинг центр", "Реферальная программа", "Карьерные консультации"))),
            enLanguageNavBarSubMenuMap = new HashMap<>(
                    Map.of("Selecty", List.of("About", "News", "Media", "Blog", "Events"),
                            "Services", List.of("Outstaffing", "Recruitment", "Software development"),
                            "Career", List.of("Working in IT", "Working in HR", "Training Center", "Referral program")));

    public List<String> getLinkText() {
        return linkText;
    }

    public List<String> getExpectedSocialLinks() {
        return expectedSocialLinks;
    }

    public List<String> getEnLanguageLinkText() {
        return enLanguageLinkText;
    }

    public Map<String, List<String>> getEnLanguageNavBarSubMenuMap() {
        return enLanguageNavBarSubMenuMap;
    }

    public Map<String, List<String>> getNavBarSubMenuMap() {
        return navBarSubMenuMap;
    }
}
