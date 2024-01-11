package Selenide;

import com.codeborne.selenide.*;
import org.openqa.selenium.*;

import java.io.*;
import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// this is not a full list, just the most common
public class Snippets {

    void browser_command_examples() {
        open("https://google.com");
        open("/customer/orders"); // -Dselenide.baseUrl=http://123.23.23.1
        open("/", AuthenticationType.BASIC,
                new BasicAuthCredentials("", "user", "password"));

        Selenide.back();  //для кнопки назад в браузере
        Selenide.refresh();  //для кнопки обновить в браузере

        Selenide.clearBrowserCookies(); //очищает куки
        Selenide.clearBrowserLocalStorage();  //очищает локальную историю
        executeJavaScript("sessionStorage.clear();"); // no Selenide command for this yet

        Selenide.confirm(); // OK в диалоговых формах
        Selenide.dismiss(); // Cancel в диалоговых формах

        Selenide.closeWindow(); // закрывает текущее окно
        Selenide.closeWebDriver(); // закрывает все окна браузера ну и сам браузер

        Selenide.switchTo().frame("new"); //iframe страничка в страничке //переход во iframe
        Selenide.switchTo().defaultContent(); // возвращение в DOM из iframe

        Selenide.switchTo().window("The Internet"); //для перехода между окнами

        var cookie = new Cookie("foo", "bar");  //создание куки
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
    }

    void selectors_examples() {
        $("div").click();  //нажать на элемент, поиск по селектору
        element("div").click(); // в Kotlin $ зарезервирован поэтому
        // прописывают element,он делает тож самое что и $

        $("div", 2).click(); // ищет 3-ий div, index начинается с 0

        $x("//h1/div").click(); //поиск по Xpath
        $(byXpath("//h1/div")).click();  //поиск по Xpath 2 вариант

        $(byText("full text")).click(); //поиск элемента по тексту
        $(withText("ull tex")).click(); //поиск элемента по подстроке
        // можно частично задавать текст

        $(byTagAndText("div", "full text")); //поиск по тегу и тексту
        $(withTagAndText("div", "ull text")); //поиск по тегу и тексту подстроки

        $("").parent(); //для поиска родителя
        $("").sibling(1); //для поиска брата или сестры
        $("").preceding(1); //для поиска предыдущего
        $("").closest("div");
        $("").ancestor("div"); // the same as closest
        $("div:last-child"); //для поиска последнего ребенка

        $("div").$("h1").find(byText("abc")).click(); //для поиска по тексту
        //  не обязательные ниже команды
        $(byAttribute("abc", "x")).click(); //проще через "[]"
        $("[abc=x]").click();

        $(byId("mytext")).click(); //проще через "#"
        $("#mytext").click();

        $(byClassName("red")).click(); //проще через "."
        $(".red").click();
    }

    void actions_examples() {  //действия
        $("").click(); //нажать ЛКМ
        $("").doubleClick(); // нажать x2 ЛКМ
        $("").contextClick(); //нажать ПКМ

        $("").hover(); //навести мышку и не кликать

        $("").setValue("text"); //вписывает в поле значение
        // (если значение уже есть то будет написано значение заново)
        $("").append("text"); // дописывает в уже имеющееся значение
        // в конце нужное значение
        $("").clear(); //очищает значение в строке, но работает не всегда
        $("").setValue(""); // тоже очищает значение в строке

        $("div").sendKeys("c"); // имитация нажатия клавиш
        // на каких то элементах т.е горячие клавиши
        actions().sendKeys("c").perform(); //нажать на клавишу без привязки к элементу
        actions().sendKeys(Keys.chord(Keys.CONTROL, "f")).perform(); // сочетание горячих клавиш (CTRL+F)
        $("html").sendKeys(Keys.chord(Keys.CONTROL, "f")); //сочетание горячих клавиш
        // на элементе html

        $("").pressEnter();
        $("").pressEscape();
        $("").pressTab();


        // complex actions with клавиатура и мышь, example (похоже на DragAndDrop)
        actions().moveToElement($("div")).clickAndHold().moveByOffset(300, 200).release().perform();

        // old html actions don't work with many modern frameworks
        $("").selectOption("dropdown_option"); //для выбора из старой версии DropDawn
        $("").selectRadio("radio_options"); //для старой версии чекбоксов

    }

    void assertions_examples() {  //проверки
        $("").shouldBe(visible); //ожидание появления элемента
        $("").shouldNotBe(visible);//ожидание не появления элемента
        $("").shouldHave(text("abc"));//ожидание появления элемента
        // с нужным текстом
        $("").shouldNotHave(text("abc"));//ожидание не появления
        // элемента с нужным текстом
        $("").should(appear);
        $("").shouldNot(appear);


        //longer timeouts //таймаут можно увеличить для отобработки или появления кнопки
        $("").shouldBe(visible, Duration.ofSeconds(30));

    }

    void conditions_examples() {
        //в любой assertion(проверке) должно быть condition(состояние)
        $("").shouldBe(visible);
        $("").shouldBe(hidden);

        $("").shouldHave(text("abc"));
        $("").shouldHave(exactText("abc"));
        $("").shouldHave(textCaseSensitive("abc"));
        $("").shouldHave(exactTextCaseSensitive("abc"));
        $("").should(matchText("[0-9]abc$"));

        $("").shouldHave(cssClass("red")); //проверяет что есть только 1 класс
        $("").shouldHave(cssValue("font-size", "12"));
        //это настоящие свойства элемента находятся на вкладке Element>Computed

        $("").shouldHave(value("25"));//для сравнения текстовых полей
        $("").shouldHave(exactValue("25"));
        $("").shouldBe(empty);//проверка пустого элемента

        $("").shouldHave(attribute("disabled"));
        //проверка существования у элемента атрибута
        $("").shouldHave(attribute("name", "example"));
        //проверка что у атрибута элемента есть значение
        $("").shouldHave(attributeMatching("name", "[0-9]abc$"));
        //проверка что у атрибута элемента есть значение, но более точно

        $("").shouldBe(checked); // для чекбокса

        // Предупреждение! Проверяет только, находится ли он в DOM, а не видим ли он!
        // В большинстве тестов вам это не понадобится!
        $("").should(exist);//проверяет существует ли элемент
        // когда он не видим

        // Предупреждение! Проверяет только атрибут «отключено»!
        // Не будет работать со многими современными фреймворками.
        // т.к disabled может не отображаться в DOM
        $("").shouldBe(disabled);
        $("").shouldBe(enabled);
    }

    void collections_examples() {

        $$("div"); // поиск коллекции элементов

        $$x("//div"); // поиск коллекции элементов by XPath

        // selections
        $$("div").filterBy(text("123")).shouldHave(size(1));
        //filterBy (фильтрация) ищет только те элементы которые удовлетворяют условиям
        //condition может быть любой
        $$("div").excludeWith(text("123")).shouldHave(size(1));
        //excludeWith ищет только те элементы которые не удовлетворяют условиям
        //condition может быть любой


        //действий с акциями нету поэтому только проверку или
        // операции которые сводят к одному элементу (first, last, get)
        $$("div").first().click();
        elements("div").first().click();
        // $("div").click();
        $$("div").last().click();
        $$("div").get(1).click(); // the second! (start with 0)
        $("div", 1).click(); // same as previous
        $$("div").findBy(text("123")).click(); //  finds first

        // assertions
        $$("").shouldHave(size(0));
        //проверка что коллекция пустая
        $$("").shouldBe(CollectionCondition.empty); // the same

        $$("").shouldHave(texts("Alfa", "Beta", "Gamma"));
        //проверка на то что коллекция содержит точное количество элементов
        $$("").shouldHave(exactTexts("Alfa", "Beta", "Gamma"));
        //проверка точного текста элементов коллекции

        $$("").shouldHave(textsInAnyOrder("Beta", "Gamma", "Alfa"));
        //если порядок текста не важен
        $$("").shouldHave(exactTextsCaseSensitiveInAnyOrder("Beta", "Gamma", "Alfa"));
        //проверка текста регистр важен
        $$("").shouldHave(itemWithText("Gamma")); // only one text
        //проверка, что элемент есть, но не важно в каком месте
        $$("").shouldHave(sizeGreaterThan(0));
        $$("").shouldHave(sizeGreaterThanOrEqual(1));
        $$("").shouldHave(sizeLessThan(3));
        $$("").shouldHave(sizeLessThanOrEqual(2));
        //проверка, что в коллекции есть элементы


    }

    void file_operation_examples() throws FileNotFoundException {

        File file1 = $("a.fileLink").download(); // только для <a href=".."> links
        File file2 = $("div").download(DownloadOptions.using(FileDownloadMode.FOLDER));
        //более распространенные варианты, но могут возникнуть проблемы с Grid/Selenoid

        File file = new File("src/test/resources/readme.txt");
        $("#file-upload").uploadFile(file);
        $("#file-upload").uploadFromClasspath("readme.txt");
        //не забудьте кликнуть
        $("uploadButton").click();
    }

    void javascript_examples() {
        executeJavaScript("alert('selenide')");
        //запускает любую команду javascript
        executeJavaScript("alert(arguments[0]+arguments[1])", "abc", 12);
        //пример работы с аргументами
        long fortytwo = executeJavaScript("return arguments[0]*arguments[1];", 6, 7);
        //вычисляет какие-то значения

    }
}

