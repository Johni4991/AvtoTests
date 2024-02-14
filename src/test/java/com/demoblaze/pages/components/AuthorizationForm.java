package com.demoblaze.pages.components;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationForm {
    @Test
    public void loginForm() {
        $("#login2").click();
        $("#loginusername").setValue("test123@mail.ru");
        $("#loginpassword").setValue("alexandr123");
        $("[onclick='logIn()']").click();
        $("#nameofuser").shouldBe(visible);
    }

}
