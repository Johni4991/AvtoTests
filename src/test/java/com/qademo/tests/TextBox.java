package com.qademo.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBox {
    @BeforeAll
    static void config() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }


    @Test
    void box() {

        open("/automation-practice-form");
        /*$(".main-header").shouldHave(text("Text Box"));
        $("#userName").setValue("Little shark");
        $("#userEmail").setValue("shark@mail.com");
        $("#currentAddress").setValue("address one");
        $("#permanentAddress").setValue("addres two");
        $("#submit").click();
        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave(text("Little shark"));
        $("#output").$("#userEmail").shouldHave(text("shark@mail.com"));*/
    }
}
