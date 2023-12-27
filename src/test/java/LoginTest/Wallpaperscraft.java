package LoginTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Wallpaperscraft {
    @Test
    void wallpapers() {
        Configuration.holdBrowserOpen = true;
        open ("https://wallpaperscraft.com/");
        Configuration.timeout = 20000;
        $("[class='gui-heading__title']").shouldHave(text("Desktop wallpapers, hd backgrounds"));
        $("[placeholder='Search']").setValue("girl").pressEnter();
    }
}
