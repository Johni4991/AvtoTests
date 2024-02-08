package com.demoblaze;

import org.junit.jupiter.api.Test;

public class PurchaseLaptop extends BaseUrl{
    @Test
    public void addLaptop() {
    metodsPages.openPage()
    .clickLaptops()
    .addProduct(
            "MacBook Pro")
    .openCart(
            "Products",
            "MacBook Pro")
    .clickHome()
    .clickLaptops()
    .addProduct(
            "MacBook air")
    .openCart(
            "Products",
            "MacBook air")
    .orderFormIphone(
            "Жека",
            "Russia",
            "Izh",
            "1234567890",
            "October",
            "2024")
    .orderFormPurchase(
            "Thank you for your purchase!",
            "Id: ",
            "Card Number: 123456789",
            "Name: Жека");
    }
}
