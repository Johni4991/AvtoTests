package loginTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Wallpaperscraft {
    @Test
    void wallpapers() throws InterruptedException {
        Configuration.holdBrowserOpen = true;
        open ("https://wallpaperscraft.com/");
        $(".gui-heading").wait(40000);
        $("[.gui-heading]")
                .shouldHave(text("Desktop wallpapers, hd backgrounds"));
        $("[.search__toggler]").setValue("girl").pressEnter();
    }
}
