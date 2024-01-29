package com.github;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class GoogleSearch {
    @Test
    void SearchTest() {
        Configuration.holdBrowserOpen = true;
        open ("https://www.google.com");
        $("[type='search']").setValue("CSS Selector").pressEnter();
    }
}
