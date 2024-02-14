package com.qademo.tests;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class RegistrationWithJavaFackerTests extends ForTestsBase {
    @Test
    void succesfulRegistrationTest() {
        Faker faker = new Faker();  //randoms values

        String firstName = faker.name().firstName();
        String lastName1 = faker.name().lastName();
        String streetAddress = faker.internet().emailAddress();

//Test data
        String userName = firstName;
        String lastName = lastName1;
        String email = streetAddress;
        String gender = "Other";
        String phone = "1234567890";
        String day = "30";
        String month = "July";
        String yeah = "2008";
        String subjects = "Maths";
        String hobbies = "Sports";
        String picture = "img/onePux.png";
        String address = "Some address 1";
        String state = "NCR";
        String city = "Delhi";
//ACT
        registrationPage.openPage()
            .setFirstName(userName)
            .setLastName(lastName)
            .setEmail(email)
            .setGender(gender)
            .setPhone(phone)
            .setBirthDate(day, month, yeah)
            .setSubjects(subjects)
            .setHobbies(hobbies)
            .addPicture(picture)
            .setCurrentAddress(address)
            .setBirthGeo(state, city)
//Appers
            .verifyResultsModalAppers()
            .verifyResult(
                    "Student Name",
                    userName + " " + lastName)
            .verifyResult("Student Email", email)
            .verifyResult("Gender", "Other")
            .verifyResult("Mobile", "1234567890")
            .verifyResult("Date of Birth", "30 July,2008");
    }
}
