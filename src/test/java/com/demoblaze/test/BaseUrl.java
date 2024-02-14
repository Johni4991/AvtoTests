package com.demoblaze.test;

import com.codeborne.selenide.Configuration;
import com.demoblaze.pages.MetodsPages;
import com.demoblaze.pages.components.AuthorizationForm;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class BaseUrl {
    MetodsPages metodsPages = new MetodsPages();
    AuthorizationForm authorizationForm = new AuthorizationForm ();
    @Description ("Класс открывает стартовую страницу с нужными параметрами для браузера")
    @BeforeAll
    static void basicUrl() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        open("https://www.demoblaze.com");
    }
}
