package guru.qa.pages;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    public HomePage openHomePage() {
        open(baseUrl);
        return this;
    }

    public HomePage openForms() {
        $("[href=\"/forms\"]").click();
        return this;
    }

    public HomePage openElements() {
        $("[href=\"/elements\"]").click();
        return this;
    }

    public RegistrationPage  openRegistrationPage() {
        $("[href=\"/automation-practice-form\"]").click();
        return new RegistrationPage();
    }

    public TextBoxPage openTextBoxPage() {
        open("[href=\"/text-box\"]");
        return new TextBoxPage();
    }
}
