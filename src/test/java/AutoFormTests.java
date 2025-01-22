import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.DownloadActions.click;

public class AutoFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy ="eager";
        Configuration.holdBrowserOpen =false;
        Configuration.browserSize ="1920x1080";
        Configuration.baseUrl="https://demoqa.com";
    }
    @Test
    public void fillFormTest () {

        open("/automation-practice-form");
        $("#firstName").setValue("Pavel");
        $("#lastName").setValue("Aleksanochkin");
        $("#userEmail").setValue("Aleksanochkin@gmail.com");
        ///  Выбираем Пол
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("7912312312");
        ///  Выбираем ДР
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1996");
        $(".react-datepicker__month").$(byText("3")).click();
        ///  Грузим Пикчу
        String filePath = "C:/Users/PavelPC/Desktop/Исх. № ФС-3.25 от 22.01.pdf";
        $("#uploadPicture").setValue(filePath);
        ///  Выбираем Хобби
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#currentAddress").setValue("Moscow Never Sleeps");
        ///  Выбираем Штат
        $("#state").click();
        $("#state").$(byText("NCR")).click();
        ///  Выбираем Город
        $("#city").click();
        $("#city").$(byText("Noida")).click();
        $("#submit").click();
        ///  Проверки
       $(".table-responsive").shouldHave(text("Pavel Aleksanochkin"));
       $(".table-responsive").shouldHave(text("Aleksanochkin@gmail.com"));
       $(".table-responsive").shouldHave(text("Male"));
       $(".table-responsive").shouldHave(text("7912312312"));
       $(".table-responsive").shouldHave(text("03 April,1996"));
       $(".table-responsive").shouldHave(text("Sports"));
       $(".table-responsive").shouldHave(text("Исх. № ФС-3.25 от 22.01.pdf"));
       $(".table-responsive").shouldHave(text("Moscow Never Sleeps"));
       $(".table-responsive").shouldHave(text("NCR Noida"));
    }


}