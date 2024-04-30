package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import utils.RandomUtils;

public class TestBase extends RandomUtils {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1180";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
       }
}
