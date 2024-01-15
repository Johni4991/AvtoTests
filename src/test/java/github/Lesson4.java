package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lesson4 {
    @Test
    void BuildLikeTheBest(){
        Configuration.holdBrowserOpen = true;
        open("https://github.com/");
        $$(".d-lg-flex").get(1).hover();
        $$(".HeaderMenu-dropdown-link").findBy(text("Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered"));
        String expectedUrl = "https://github.com/enterprise";
        String currentUrl = url();
        assertEquals(expectedUrl, currentUrl);

    }
}