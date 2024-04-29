package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckResultInFieldComponent {
    SelenideElement resultField = $("#output");

    public CheckResultInFieldComponent checkResult(String key, String value) {
        resultField.$(byText(key)).shouldHave(text(value));
        return this;
    }

}
