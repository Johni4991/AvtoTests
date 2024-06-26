package forFiles;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import forFiles.model.Glossary;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.io.Zip;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class FilesParsingTest {
//    @Test
//    void pdfParseTest() throws Exception {
//        open("https://junit.org/junit5/docs/current/user-guidle/"); //404
//        File downloadedPdf = $("a[href='junit-user-guide-5.9.1.pdf']").download();
//            PDF content = new PDF(downloadedPdf);
//            assertThat(content.author).contains("Sam Brannen");
//    }
    ClassLoader cl = FilesParsingTest.class.getClassLoader();
//    @Test
//    void xlsParseTest() throws Exception { // конфликт в версиях зависимостей
//
//        try (InputStream resourceAsStrem = cl.getResourceAsStream("xls/Тестовый xls.numbers")) {
//            XLS content = new XLS(resourceAsStrem);
//            assertThat(content.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue()).contains("Тест");
//        }
//    }
    @Test
    void csvParseTest() throws Exception {
        try (
                InputStream resource = cl.getResourceAsStream("csv/testDate.csv");
                CSVReader reader = new CSVReader(new InputStreamReader(resource))
        ) {
            List<String[]> content = reader.readAll();
            assertThat(content.get(0)[1]).contains("https://qameta.io");
        }
    }
    @Test
    void zipParseTest() throws Exception {
        try (
                InputStream resource = cl.getResourceAsStream("zip/testZip.zip");
                ZipInputStream zis = new ZipInputStream(resource)
        ) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                assertThat(entry.getName()).isEqualTo("bios.jpg");
            }
        }
    }
    @Test
    void jsonParseTest() throws Exception {
        Gson gson = new Gson();
        try (
                InputStream resource = cl.getResourceAsStream("js/glossary.json");
                InputStreamReader reader = new InputStreamReader(resource)
        ) {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            assertThat(jsonObject.get("title").getAsString()).isEqualTo("example glossary");
            assertThat(jsonObject.get("GlossDiv").getAsJsonObject().get("title").getAsString()).isEqualTo("S");


        }
    }
    @Test
    void jsonParseImprovedTest() throws Exception {
        Gson gson = new Gson();
        try (
            InputStream resource = cl.getResourceAsStream("js/glossary.json");
            InputStreamReader reader = new InputStreamReader(resource)
        ) {
            Glossary jsonObject = gson.fromJson(reader, Glossary.class);
            assertThat(jsonObject.title).isEqualTo("example glossary");
            assertThat(jsonObject.glossDiv.title).isEqualTo("S");
            assertThat(jsonObject.glossDiv.flag).isTrue();
        }
    }
}
