package com.github.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class AllureTest {
    @Test
    public void efef() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $("[data-hotkey='s,/']").click();
        $("[name='query-builder-test']").setValue("eroshenkoam/allure-example").pressEnter();

        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $(withText("#80")).should(Condition.exist);
    }
}
