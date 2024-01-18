package com.demoblaze;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class OneTest {
    @Test
    void oneTest() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";

        open("https://www.demoblaze.com/index.html#");
        $$(".hrefch").findBy(text("Iphone 6 32gb")).click();
        $(".name").shouldHave(text("Iphone 6 32gb"));
        $(".btn-success").click();
        Selenide.confirm();
        $("#cartur").click();
        $(".col-lg-8").shouldHave(text("Products"));
        $(".table-responsive").shouldHave(text("Iphone 6 32gb"));
        $(".btn-success").click();
        $("#name").setValue("Evgeniy");
        $("#country").setValue("Russia");
        $("#city").setValue("Izhevsk");
        $("#card").setValue("123456789");
        $("#month").setValue("October");
        $("#year").setValue("1994");
        $$(".modal-footer").findBy(text("Purchase")).click();
    }
}
