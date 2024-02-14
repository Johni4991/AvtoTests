package com.qademo.tests;

import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import com.qademo.pages.RegistrationPage;

public class ForTestsBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "2560x1600";
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadTimeout = 350000;    //таймаут selenium через selenide
    }
}