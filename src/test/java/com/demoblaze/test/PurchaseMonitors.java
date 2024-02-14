package com.demoblaze.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PurchaseMonitors extends BaseUrl {
    @Test
    void addMonitors() {
        metodsPages.openPage()
                .clickCategories("Monitors")
                .addProduct("Apple monitor 24")
                .clickHome()
                .clickCategories("Monitors")
                .clickNext()
                .addProduct("Dell i7 8gb")
                .clickHome()
                .clickCategories("Monitors")
                .clickNext()
                .addProduct("2017 Dell 15.6 Inch")
                .openCart("Products", "Dell i7 8gb")
                .openCart("Products", "Apple monitor 24")
                .openCart("Products", "2017 Dell 15.6 Inch");
    }
}
