package tests;

import com.github.javafaker.Faker;
import utils.RandomUtils;

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
        return String.valueOf(dayOfMonth);
    }

    public String getRandomMonth() {
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        return new DateFormatSymbols().getMonths()[month];
    }

    public String getRandomYear() {
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        return String.valueOf(year);
    }

    public String getRandomGender() {
        String[] gender = {"Male", "Female", "Other"};
        return RandomUtils.getRandomItemFromArray(gender);
    }

    public String getRandomSubject() {
        String[] subject = {"Chemistry", "Computer Science", "Economics", "History", "Hindi", "Arts", "Commerce", "Civics", "Physics",
                "Biology", "Accounting", "Maths", "Social Studies"};
        return RandomUtils.getRandomItemFromArray(subject);
    }

    public String getRandomHobby() {
        String[] hobby = {"Sports", "Reading", "Music"};
        return RandomUtils.getRandomItemFromArray(hobby);
    }

    public String getRandomState() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return RandomUtils.getRandomItemFromArray(state);
    }

    public String getRandomCity(String state) {
        String[] city;
        if (state.equals("NCR")) {
            city = new String[] {"Delhi", "Gurgaon", "Noida"};
        } else if (state.equals("Uttar Pradesh")) {
            city = new String[] {"Agra", "Lucknow", "Merrut"};
        } else if (state.equals("Rajasthan")) {
            city = new String[] {"Jaipur", "Jaiselmer"};
        } else {
            city = new String[] {"Karnal", "Panipat"};
        }
        return RandomUtils.getRandomItemFromArray(city);
    }
}
