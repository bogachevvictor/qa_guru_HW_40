package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;
import guru.qa.pages.components.ResponsiveTableComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage extends HomePage {
    public static SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            userPictureUpload = $("#uploadPicture"),
            userCurrentAddress = $("#currentAddress"),
            userStateInput = $("#state"),
            stateWrapper = $("#react-select-3-listbox"),
            cityWrapper = $("#react-select-4-listbox"),
            userCityInput = $("#city"),
            submitButton = $("#submit"),
            validationCheck = $("#userForm");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResponsiveTableComponent responsiveTableComponent = new ResponsiveTableComponent();

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value){
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);

        return this;
    }

//    public RegistrationPage setDateOfBirth(String day, String month, String year){
//        calendarInput.click();
//        calendarComponent.setDate(day, month, year);
//
//        return this;
//    }

    public RegistrationPage setDateOfBirth(int day, int month, int year){
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value){
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String value){
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value){
        userPictureUpload.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value){
        userCurrentAddress.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value){
        userStateInput.click();
        stateWrapper.shouldBe(visible).$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value){
        userCityInput.click();
        cityWrapper.shouldBe(visible).$(byText(value)).click();
        return this;
    }

    public void clickSubmit(){
        submitButton.click();

    }

    public RegistrationPage checkResult(String key, String value){
        responsiveTableComponent.checkTable(key, value);
        return this;
    }

    public RegistrationPage checkFailResult(){
        validationCheck.shouldHave(cssClass("was-validated")).shouldNotHave(cssClass("table-responsive"));
//        $("#app").shouldNotHave(cssClass("table-responsive"));
        return this;
    }
}

