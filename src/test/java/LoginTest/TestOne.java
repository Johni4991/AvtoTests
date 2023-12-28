package LoginTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestOne {
        @Test
        @Owner("Горбунов Евгений")
        @Description("Тест проверяет страницу QA GURU")
        void successFullLoginTests() {
            //Configuration.holdBrowserOpen = true;   //браузер не закроется
            //Configuration.timeout = 1000; //таймаут
            open ("https://qa.guru/cms/system/login");  //переход на страницу
            $(".login-form").shouldHave(text("Войти"));  //проверка наличия текста на форме
            $("[name=email]").setValue("gorbunov4991@mail.ru");  //qagurubot@gmail.com
            $("[name=password]").setValue("Alex1994").pressEnter(); //qagurupassword
            $(".main-header__login").click();
            $(".logined-form").shouldHave(text("Здравствуйте, Евгений"));
        }
}
