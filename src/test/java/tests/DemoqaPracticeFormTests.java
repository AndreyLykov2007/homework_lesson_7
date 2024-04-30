package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.components.CheckResultInTableComponent;
import pages.RegistrationPage;
import java.util.Locale;

public class DemoqaPracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CheckResultInTableComponent checkResultComponent = new CheckResultInTableComponent();
    Faker faker = new Faker(new Locale("en-US"));
    TestData testData = new TestData();


    private final String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = testData.getRandomGender(),
            phone = faker.number().digits(10),
            month = testData.getRandomMonth(),
            dayOfMonth = testData.getRandomDayOfMonth(),
            year = testData.getRandomYear(),
            subject = testData.getRandomSubject(),
            hobby = testData.getRandomHobby(),
            address = faker.address().fullAddress(),
            state = testData.getRandomState(),
            city = testData.getRandomCity(state);

    @Test
    void successfulRegistrationFilledAllFieldsTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setMobilePhone(phone)
                .setDateOfBirth(dayOfMonth, month, year)
                .setSubject(subject)
                .setHobbie(hobby)
                .uploadPicture("example.jpg")
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        checkResultComponent.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phone)
                .checkResult("Date of Birth", dayOfMonth + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", "example.jpg")
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void successfulRegistrationOnlyRequiredFieldsTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setMobilePhone(phone)
                .setDateOfBirth(dayOfMonth, month, year)
                .clickSubmit();

        checkResultComponent.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phone)
                .checkResult("Date of Birth", dayOfMonth + " " + month + "," + year);
    }

    @Test
    void notFilledLastNameFieldNegativeTest() {
        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setUserEmail(email)
                .setGender(gender)
                .setMobilePhone(phone)
                .setDateOfBirth(dayOfMonth, month, year)
                .setSubject(subject)
                .setHobbie(hobby)
                .uploadPicture("example.jpg")
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        checkResultComponent.checkResultWindowNotAppeared();
    }
}
