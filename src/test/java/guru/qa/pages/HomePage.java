package guru.qa.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    @Step("Открываем страницу {baseUrl}")
    public HomePage openHomePage() {
        open(baseUrl);
        return this;
    }

    @Step("Открываем страницу формы /forms")
    public HomePage openForms() {
        $("[href=\"/forms\"]").click();
        return this;
    }

    @Step("Открываем струница элементов /elements")
    public HomePage openElements() {
        $("[href=\"/elements\"]").click();
        return this;
    }

    @Step("Открываем страницу регистрации /automation-practice-form")
    public RegistrationPage  openRegistrationPage() {
        $("[href=\"/automation-practice-form\"]").click();
        return new RegistrationPage();
    }

    @Step("Открываем текстовый блок /text-box")
    public TextBoxPage openTextBoxPage() {
        open("[href=\"/text-box\"]");
        return new TextBoxPage();
    }
}
