package com.qademo;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import com.qademo.pages.RegistrationPage;


public class ForTestsBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
}