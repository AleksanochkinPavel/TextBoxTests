import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class automationpracticeformTests {
    @BeforeAll
    static void beforeAll() {
    Configuration.pageLoadStrategy ="eager";
    Configuration.holdBrowserOpen =true;
    Configuration.browserSize ="1920x1080";
    Configuration.baseUrl="https://demoqa.com";
}
    @Test
     public void fillFormTest () {

        open("/text-box");
        $("#userName").setValue("PavelAleksanochkin");
        $("#userEmail").setValue("Aleksanochkin@gmail.com");
        $("#currentAddress").setValue("Moscow Never Sleeps");
        $("#permanentAddress").setValue("Moscow Never Sleeps 1");
        $("#submit").click();

        $("#output #name").shouldHave(text("PavelAleksanochkin"));
        $("#output #email").shouldHave(text("PavelAleksanochkin"));
        $("#output #currentAddress").shouldHave(text("PavelAleksanochkin"));
        $("#output #permanentAddress").shouldHave(text("PavelAleksanochkin"));
    }


}