package com.github;

import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenide {
    @Test
    void solntsevSouldBeTheTopContributor() {
    //Шаги теста:
        //Открыть страницу репозитория селенида
        open("https://github.com/selenide/selenide");
        //Подвести мышку к первому аватару из блока contributors
        $(".BorderGrid").$(byText("Contributors"))
                .ancestor(".BorderGrid-row").$$("ul li").first()
                .hover();
        //проверка: во всплывающем окне есть текст Andrei Solntsev
        $$(".Popover").findBy(visible)
                .shouldHave(text("Andrei Solntsev"));
    }
}
