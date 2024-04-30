package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    SelenideElement calendarInput = $(".react-datepicker-wrapper");

    public void setDate(String day, String month, String year) {
        calendarInput.click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);


        if (day.length() > 1) {
            $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
        } else
            $(".react-datepicker__day--00" + day + ":not(.react-datepicker__day--outside-month)").click();
    }

    }

    //react-datepicker__day react-datepicker__day--009 react-datepicker__day--outside-month