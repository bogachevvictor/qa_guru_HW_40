package guru.qa.tests;

import guru.qa.TestBase;
import guru.qa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

import static guru.qa.utils.RandomUtils.*;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();
    String firstName = getRandomFirstName(),
            userEmail = getRandomEmail(),
            userCurrentAddress = getRandomCurrentAddress(),
            userPermanentAddress = getRandomCurrentAddress();


    @Test
    void fillFormTest() {
        textBoxPage.openHomePage().openElements().openTextBoxPage()
                .setFirstName(firstName)
                .setEmail(userEmail)
                .setCurrentAddress(userCurrentAddress)
                .setPermanentAddress(userPermanentAddress)
                .clickSubmit()
                .checkResult("name", firstName)
                .checkResult("email", userEmail)
                .checkResult("currentAddress", userCurrentAddress)
                .checkResult("permanentAddress", userPermanentAddress);
    }
}
