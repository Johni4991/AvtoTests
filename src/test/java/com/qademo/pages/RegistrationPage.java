package com.qademo.pages;

import com.codeborne.selenide.SelenideElement;
import com.qademo.pages.components.GeolocationComponent;
import com.qademo.pages.components.CalendarComponent;
import com.qademo.pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private GeolocationComponent geolocationComponent = new GeolocationComponent();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        $(firstNameInput).setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        $(lastNameInput).setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        $("#userEmail").setValue(value); // todo move to Selenide element
        return this;
    }

    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPhone(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String yeah) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, yeah);
        return this;
    }

    public RegistrationPage setSubjects (String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies (String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPage addPicture (String value) {
        $("#uploadPicture").uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress (String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegistrationPage setBirthGeo (String state, String city) {
        geolocationComponent.setGeo(state, city);
        return this;
    }

    public RegistrationPage verifyResultsModalAppers() {
        registrationResultsModal.verifyModalAppers();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }
}
