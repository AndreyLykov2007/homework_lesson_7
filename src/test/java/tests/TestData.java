package tests;

import com.github.javafaker.Faker;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("en-US"));

    Date date = faker.date().birthday(16, 70);
    Calendar calendar = Calendar.getInstance();


    public String getRandomDayOfMonth() {
        calendar.setTime(date);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        return String.format("%02d", dayOfMonth);
    }

    public String getRandomMonth() {
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        return new DateFormatSymbols(Locale.ENGLISH).getMonths()[month];
    }


    public String getRandomYear() {
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        return String.valueOf(year);
    }

    public String getRandomCity(String state) {
        String city;
        if (state.equals("NCR")) {
            city = faker.options().option("Delhi", "Gurgaon", "Noida");
        } else if (state.equals("Uttar Pradesh")) {
            city = faker.options().option("Agra", "Lucknow", "Merrut");
        } else if (state.equals("Rajasthan")) {
            city = faker.options().option("Jaipur", "Jaiselmer");
        } else {
            city = faker.options().option("Karnal", "Panipat");
        }
        return (city);
    }
}
