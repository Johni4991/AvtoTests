package com.qademo.tests;


import org.junit.jupiter.api.Test;

import static com.qademo.utils.RandomUtils.randomEmail;
import static com.qademo.utils.RandomUtils.randomString;


public class RegistrationWithPageObjectsTests extends ForTestsBase {
    @Test
    void succesfulRegistrationTest() {
//Test data
        String userName = randomString(10);
        String lastName = randomString(10);
        String email = randomEmail();
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
            .verifyResult("Student Email", "alex@egorov.com")
            .verifyResult("Gender", "Other")
            .verifyResult("Mobile", "1234567890")
            .verifyResult("Date of Birth", "30 July,2008");
    }
}
