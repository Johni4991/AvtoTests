package com.demoblaze.test;

import org.junit.jupiter.api.Test;

public class PurchaseLaptops extends BaseUrl {
    @Test
    public void addLaptop() {
    authorizationForm.loginForm();
    metodsPages.openPage()
    .clickCategories("Laptops")
    .addProduct(
            "MacBook Pro")
    .openCart(
            "Products",
            "MacBook Pro")
    .clickHome()
    .clickCategories("Laptops")
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
            "Name: Жека")
    .clickLogOut();
    }
}
