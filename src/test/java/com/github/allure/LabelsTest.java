package com.github.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {
    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("Gorbunov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "GitHub", url = "https://testing.github.com")
    @DisplayName("Создание Isuue для авторизованного пользователя")
    public void testStaticLabels() {

    }
    @Test
    public void testDynamicLabels() {

    }
}
