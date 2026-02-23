package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static guru.qa.utils.RandomUtils.*;
import static guru.qa.utils.RandomUtils.getRandomCity;

public class TextBoxTests {

    String firstName = getRandomFirstName(),
            userEmail = getRandomEmail(),
            userCurrentAddress = getRandomCurrentAddress(),
            userPermanentAddress = getRandomCurrentAddress();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue(firstName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(userCurrentAddress);
        $("#permanentAddress").setValue(userPermanentAddress);
        $("#submit").click();

        $("#output #name").shouldHave(text(firstName));
        $("#output #email").shouldHave(text(userEmail));
        $("#output #currentAddress").shouldHave(text(userCurrentAddress));
        $("#output #permanentAddress").shouldHave(text(userPermanentAddress));
    }
}
