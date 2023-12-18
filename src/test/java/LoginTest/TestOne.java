package LoginTest;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestOne {
        @Test
        @Owner("Горбунов Евгений")
        @Description("Тест проверяет рандомную страницу")
        void successFullLoginTests() {
            //Configuration.holdBrowserOpen = true;   //браузер не закроется
            Configuration.timeout = 1000; //таймаут
            open ("https://qa.guru/cms/system/login");  //переход на страницу
            $(".login-form").shouldHave(text("Войти"));  //проверка наличия текста на форме
            $("[name=email]").setValue("qagurubot@gmail.com");
            $("[name=password]").setValue("qagurupassword").pressEnter();
            $(".main-header__login").click();
            $(".logined-form").shouldHave(text("Здравствуйте, QA_GURU_BOT"));
        }
}
