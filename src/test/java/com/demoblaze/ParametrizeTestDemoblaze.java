package com.demoblaze;

import com.demoblaze.pages.MetodsPages;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static com.codeborne.selenide.Selenide.*;

public class ParametrizeTestDemoblaze {
    MetodsPages metodsPages = new MetodsPages();
    @CsvFileSource(resources = "/csv/demoBlazeDate.csv")
    @ParameterizedTest(name = "Добавление {0} в корзину и проверка наименования {0}")
    void parametrizeDemoblaze(
            String product
    ) {
        open("https://www.demoblaze.com");
        metodsPages.addProduct(product);
        metodsPages.openCart("Products", product);
    }
}
