package com.demoblaze.pages;

import com.codeborne.selenide.Selenide;
import com.demoblaze.pages.components.ClickElements;
import com.demoblaze.pages.components.OrderConfirmationForm;
import com.demoblaze.pages.components.OrderForm;
import com.demoblaze.utils.RandomsValues;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MetodsPages {
    OrderForm orderForm = new OrderForm();
    OrderConfirmationForm orderConfirmationForm = new OrderConfirmationForm();
    ClickElements clickElements = new ClickElements();
    RandomsValues randomsValues = new RandomsValues();
    private final String TITLE_TEXT = "PRODUCT STORE";
    public MetodsPages openPage() {
        $("#nava").shouldHave(text(TITLE_TEXT));
        return this;
    }
    public MetodsPages addProduct(String value) {
        $$(".hrefch").findBy(text(value)).click();
        $(".name").shouldHave(text(value));
        $(".btn-success").click();
        Selenide.confirm();
        return this;
    }
    public MetodsPages openCart(String tabName, String value) {
        $("#cartur").click();
        $(".col-lg-8").shouldHave(text(tabName));
        $(".table-responsive").shouldHave(text(value));
        return this;
    }
    public MetodsPages orderFormIphone(String name, String country, String city, String card, String month, String yeah) {
        orderForm.ordering(name, country, city, card, month, yeah);
        return this;
    }
    public MetodsPages randomValuesOrderForm() {
        randomsValues.setFaker();
        return this;
    }
    public MetodsPages orderFormPurchase(String title, String id, String cardNumber, String name) {
        orderConfirmationForm.orderIphone(title, id, cardNumber, name);
        return this;
    }
    public MetodsPages clickCategories(String category) {
        clickElements.clickCategories(category);
        return this;
    }
    public MetodsPages clickHome() {
        clickElements.clickHome();
        return this;
    }
    public MetodsPages clickCart() {
        clickElements.clickCart();
        return this;
    }
    public MetodsPages clickLogin() {
        clickElements.clickLogin();
        return this;
    }
    public MetodsPages clickNext() {
        clickElements.clickNext();
        return this;
    }
    public MetodsPages clickLogOut() {
        clickElements.clickLogOut();
        return this;
    }
}

