package github;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {
    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        // ARRANGE - подготовка
        // ACT - действие
        // ASSERT - проверка

        // Шаги теста
        // открыть главную страницу
        Selenide.open ("github.com");
        // ввести в поле поиска selenide нажать Enter
        Selenide.$("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        // кликнуть на первый репозиторий из списка найденых
        // проверка: заголов selenide/selenide
sleep(50000);

    }
}
