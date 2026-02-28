package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage  extends HomePage {
    public SelenideElement firstNameInput = $("#userName");
    public SelenideElement userEmailInput = $("#userEmail");
    public SelenideElement userCurrentAddress = $("#currentAddress");
    public SelenideElement userPermanentAddress = $("#permanentAddress");
    public SelenideElement submitButton = $("#submit");
    public SelenideElement formResultCheck = $("#output");

    public TextBoxPage openTextBoxPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value){
        userCurrentAddress.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value){
        userPermanentAddress.setValue(value);
        return this;
    }

    public TextBoxPage clickSubmit(){
        submitButton.click();
        return this;
    }

    public TextBoxPage checkResult(String key, String value){
        formResultCheck.$(byId(key))
                .shouldHave(text(value));
        return this;
    }

}
