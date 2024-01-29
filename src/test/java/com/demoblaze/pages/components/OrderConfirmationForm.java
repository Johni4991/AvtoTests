package com.demoblaze.pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class OrderConfirmationForm {
    public void orderIphone(String title, String id, String cardNumber, String name) {
        $(".sweet-alert").should(appear);
        $(".sweet-alert")
                .shouldHave(text(title));
        $(".sweet-alert")
                .shouldHave(text(id));
        $(".sweet-alert")
                .shouldHave(text(cardNumber));
        $(".sweet-alert")
                .shouldHave(text(name));
    }
}
