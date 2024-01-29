package com.demoblaze;

import org.junit.jupiter.api.Test;

public class AddPhoneCart extends BaseUrl {
    @Test
    void AddiPhone() {
        //ACT
        metodsPages.openPage()
        .addProduct("Iphone 6 32gb")
        .openCart("Products", "Iphone 6 32gb")
        .orderFormIphone(
                "Evgeniy",
                "Russia",
                "Izhevsk",
                "123456789",
                "October",
                "1994")
        //Appers
        .orderFormPurchase(
                "Thank you for your purchase!",
                "Id: ",
                "Card Number: 123456789",
                "Name: Evgeniy");
    }
}
