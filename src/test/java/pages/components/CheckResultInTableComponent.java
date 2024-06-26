package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckResultInTableComponent {
    SelenideElement resultTable = $(".table-responsive");

    public CheckResultInTableComponent checkResult(String key, String value) {
        resultTable.$(byText(key)).sibling(0).shouldHave(text(value));
        return this;
    }

    public CheckResultInTableComponent checkResultWindowNotAppeared() {
            resultTable.shouldNot(visible);
            return this;
    }
}
