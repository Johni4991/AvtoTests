package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class Lesson4 {
    @Test
    void BuildLikeTheBest(){
        Configuration.holdBrowserOpen = true;
        open("https://github.com/");
        $("").hover();
        $("href='/enterprise'").click();
        $("#hero-section-brand-heading").shouldHave(Condition.text("The AI-powered"));
    }
}
