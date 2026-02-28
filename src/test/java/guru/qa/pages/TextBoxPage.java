package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage  extends HomePage {
    public static SelenideElement firstNameInput = $("#userName");
    public static SelenideElement userEmailInput = $("#userEmail");
    public static SelenideElement userCurrentAddress = $("#currentAddress");
    public static SelenideElement userPermanentAddress = $("#permanentAddress");
    public static SelenideElement submitButton = $("#submit");
    public static SelenideElement formResultCheck = $("#output");

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
