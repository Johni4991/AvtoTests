package github;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {
    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        // ARRANGE - подготовка
        // ACT - действие
        // ASSERT - проверка
        Configuration.holdBrowserOpen = true;
        // Шаги теста:
        // 1. Открыть главную страницу
        open ("https://www.github.com");
        // 2. Ввести в поле поиска selenide нажать Enter
        $("[data-hotkey='s,/']").click();
        $("[name='query-builder-test']").setValue("selenide").pressEnter();
        // 3. Кликнуть на первый репозиторий из списка найденых
        $("[href='/selenide/selenide']").click();
        // 4. Проверка: заголов selenide/selenide
        $("[data-hovercard-type='organization']")
                .shouldHave(text("selenide"));
    }
}
