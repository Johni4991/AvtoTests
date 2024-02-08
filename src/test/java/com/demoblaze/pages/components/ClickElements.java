package com.demoblaze.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ClickElements {
    public void clickLaptops() {
        $$("#itemc").findBy(text("Laptops")).click();
    }
    public void clickHome() {
        $(".nav-link").click();
    }
    public void clickCart() {
        $$(".nav-link").get(3).click();
    }
    public void clickLogin() {
        $$(".nav-link").get(4).click();
    }
    public void clickNext() {
        $("#next2").click();
    }
}
