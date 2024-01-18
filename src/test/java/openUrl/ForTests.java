package openUrl;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class ForTests {
    @Test
    //@BeforeEach
    @Description("Класс для открытия тестового контура")
    public void urlForAllTests (){
        Configuration.holdBrowserOpen = true;
        open ("https://qa.guru/cms/system/login");
    }
}