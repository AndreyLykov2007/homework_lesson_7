package tests;

import org.junit.jupiter.api.Test;
import pages.components.CheckResultInTableComponent;
import pages.RegistrationPage;

public class DemoqaPracticeFormTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    CheckResultInTableComponent checkResultComponent = new CheckResultInTableComponent();

    @Test
    void successfulRegistrationFilledAllFieldsTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Alex")
                .setLastName("Ivanov")
                .setUserEmail("alexivanov20251718@gmail.com")
                .setGender("Male")
                .setMobilePhone("9999999901")
                .setDateOfBirth("28", "August", "1980")
                .setSubjects("English")
                .setHobbie("Reading")
                .uploadPicture("example.jpg")
                .setAddress("Some address 11")
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .clickSubmit();

        checkResultComponent.checkResult("Student Name", "Alex Ivanov")
                .checkResult("Student Email", "alexivanov20251718@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9999999901")
                .checkResult("Date of Birth", "28 August,1980")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "example.jpg")
                .checkResult("Address", "Some address 11")
                .checkResult("State and City", "Uttar Pradesh Agra");
    }

    @Test
    void successfulRegistrationOnlyRequiredFieldsTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Alex")
                .setLastName("Ivanov")
                .setGender("Male")
                .setMobilePhone("9999999901")
                .setDateOfBirth("28", "August", "1980")
                .clickSubmit();

        checkResultComponent.checkResult("Student Name", "Alex Ivanov")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9999999901")
                .checkResult("Date of Birth", "28 August,1980");
    }

    @Test
    void notFilledLastNameFieldNegativeTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Alex")
                .setUserEmail("alexivanov20251718@gmail.com")
                .setGender("Male")
                .setMobilePhone("9999999901")
                .setDateOfBirth("28", "August", "1980")
                .setSubjects("English")
                .setHobbie("Reading")
                .uploadPicture("example.jpg")
                .setAddress("Some address 11")
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .clickSubmit();

        checkResultComponent.checkResultWindowNotAppeared();
    }
}
