package com.demoblaze.utils;

import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RandomsValues {
    public void setFaker() {
        Faker faker = new Faker();  //randoms values

        String name = faker.name().firstName();
        String country = faker.address().country();
        String city = faker.address().city();
        String card = faker.finance().creditCard();
        String month = faker.date().toString();
        String yeah = faker.date().toString();


        $(".btn-success").click();
        $("#name").setValue(name);
        $("#country").setValue(country);
        $("#city").setValue(city);
        $("#card").setValue(card);
        $("#month").setValue(month);
        $("#year").setValue(yeah);
        $$(".btn-primary").findBy(text("Purchase")).click();
    }
}
