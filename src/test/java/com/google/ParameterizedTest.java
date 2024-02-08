package com.google;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParameterizedTest {
    @BeforeEach
    void setUp() {
        open("https://google.com");
    }
//    @CsvSource({
//            "Allure testops, https://qameta.io",
//            "Selenide, https://ru.selenide.org"
//    })
//    @ValueSource(strings = {"Allure testops, Selenide"})
    @CsvFileSource(resources = "/csv/testDate.csv")
    @org.junit.jupiter.params.ParameterizedTest
            (name = "Адрес {1} должен быть в выдаче гугла по запросу {0}")
    void googleSearchByProductNameQuery(
            String productName,
            String productURL
    ) {
        $("[name=q]").setValue(productName).pressEnter();
        $("[id=search]").shouldHave(text(productURL));
    }
}
