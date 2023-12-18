package LoginTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Wallpaperscraft {
    @Test
    void wallpapers() {
        Configuration.timeout = 20000;
        Configuration.holdBrowserOpen = true;
        open ("https://wallpaperscraft.com/");
        $(".[class=gui-heading__title]").shouldHave(text("Desktop wallpapers, hd backgrounds"));
        $(".[name=query]").setValue("girl").pressEnter();
    }
}
