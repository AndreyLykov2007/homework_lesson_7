package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement inputFirstName = $("#firstName");
    SelenideElement inputLastName = $("#lastName");
    SelenideElement inputUserEmail = $("#userEmail");
    SelenideElement setGender = $("#genterWrapper");
    SelenideElement setMobilePhone = $("#userNumber");
    SelenideElement inputSubject = $("#subjectsInput");
    SelenideElement inputHobbies = $("#hobbiesWrapper");
    SelenideElement uploadPictureForm = $("#uploadPicture");
    SelenideElement inputAddress = $("#currentAddress");
    SelenideElement inputState = $("#state");
    SelenideElement inputCity = $("#city");
    SelenideElement submitButton = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        inputFirstName.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        inputLastName.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        inputUserEmail.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        setGender.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setMobilePhone(String value) {
        setMobilePhone.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        new CalendarComponent().setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        inputSubject.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbie(String value) {
        inputHobbies.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPictureForm.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setAddress(String value) {
        inputAddress.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        inputState.click();
        $(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        inputCity.click();
        $(byText(value)).click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }
}