package pageObject;

import com.codeborne.selenide.TypeOptions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTests extends ForTestsBase {
    @Test
    void succesfulRegistrationTest() {
        String userName = "Alex";

        registrationPage.openPage()
            .setFirstName(userName)
            .setLastName("Egorov")
            .setEmail("alex@egorov.com")
            .setGender("Other")
            .setPhone("1234567890")
                .setBirthDate("30", "July", "2008");




        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/onePux.png");
        $("#currentAddress").setValue("Some address 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        registrationPage.verifyResultsModalAppers();
        $(".table-responsive").shouldHave(text("Egorov"),
                text("alex@egorov.com"), text("1234567890"));
    }
}
