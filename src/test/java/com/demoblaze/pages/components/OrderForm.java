package com.demoblaze.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OrderForm {
    public void ordering (String name, String country, String city, String card, String month, String yeah) {
        $("#name").setValue(name);
        $("#country").setValue(country);
        $("#city").setValue(city);
        $("#card").setValue(card);
        $("#month").setValue(month);
        $("#year").setValue(yeah);
        $$(".btn-primary").findBy(text("Purchase")).click();
    }
}
