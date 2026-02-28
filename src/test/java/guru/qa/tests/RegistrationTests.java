package guru.qa.tests;

import guru.qa.TestBase;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static guru.qa.enums.Month.getMonthByNumber;
import static guru.qa.utils.RandomUtils.*;

public class RegistrationTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = getRandomFirstName(),
                lastName = getRandomLastName(),
                userEmail = getRandomEmail(),
                userGender = getRandomGender(),
                userNumber = getRandomPhone(),
                userSubject = getRandomSubjects(),
                userHobby = getRandomHobbies(),
                userCurrentAddress = getRandomCurrentAddress(),
                state = getRandomState(),
                city = getRandomCityByState(state);

    @Test
    void successfulRegistrationTest() {
        registrationPage.openHomePage().openForms().openRegistrationPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setDateOfBirth(10, 10, 1989)
                .setSubject(userSubject)
                .setHobby(userHobby)
                .uploadPicture("Image_test.png")
                .setCurrentAddress(userCurrentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender",userGender)
                .checkResult("Mobile",userNumber)
                .checkResult("Date of Birth",10 + " " + getMonthByNumber(10) + "," + 1989)
                .checkResult("Subjects",userSubject)
                .checkResult("Hobbies",userHobby)
                .checkResult("Picture","Image_test.png")
                .checkResult("Address",userCurrentAddress)
                .checkResult("State and City",state + " " + city);
    }

    @Test
    void successfulRegistrationWithMinimumParamsTest() {
        registrationPage.openHomePage().openForms().openRegistrationPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .clickSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender",userGender)
                .checkResult("Mobile",userNumber);
    }

    @Test
    void unsuccessfulRegistrationWithoutRequiredFieldTest() {
        registrationPage.openHomePage().openForms().openRegistrationPage()
                .setFirstName(firstName)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .clickSubmit();

        registrationPage.checkFailResult();
    }
}
