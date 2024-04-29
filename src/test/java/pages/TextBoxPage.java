package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    SelenideElement inputFullName = $("#userName");
    SelenideElement inputEmail = $("#userEmail");
    SelenideElement inputCurrentAddress = $("#currentAddress");
    SelenideElement inputPermanentAddress = $("#permanentAddress");
    SelenideElement submitButton = $("#submit");

    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setFullName(String value) {
        inputFullName.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value) {
        inputEmail.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        inputCurrentAddress.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        inputPermanentAddress.setValue(value);
        return this;
    }

    public TextBoxPage clickSubmit() {
        submitButton.click();
        return this;
    }
}
