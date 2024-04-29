package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import pages.components.CheckResultInFieldComponent;

public class TextBoxSuccessFilledAllFields extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    CheckResultInFieldComponent checkResultOnSamePageComponent = new CheckResultInFieldComponent();

    @Test
    void textBoxSuccessTest() {
        textBoxPage.openPage()
                .setFullName("Alex Ivanov")
                .setEmail("ivan@poker.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 2")
                .clickSubmit();

        checkResultOnSamePageComponent.checkResult("Name:", "Alex Ivanov")
                .checkResult("Email:", "ivan@poker.com")
                .checkResult("Current Address :", "Some street 1")
                .checkResult("Permananet Address :", "Another street 2");
    }


}
