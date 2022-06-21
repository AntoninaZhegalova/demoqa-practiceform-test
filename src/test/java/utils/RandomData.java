package utils;

import com.github.javafaker.Faker;

import java.util.Random;

public class RandomData {
    static Faker faker = new Faker();

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getUserMail() {
        return faker.internet().emailAddress();
    }

    public static String getUserNumber() {
        return String.valueOf(faker.number().randomNumber(10, true));
    }

    public static String getDay() {
        return String.valueOf(faker.number().numberBetween(1, 28));
    }

    public static String getYear() {
        return String.valueOf(faker.number().numberBetween(1970, 2022));
    }

    public static String getCurrentAddress() {
        return faker.address().fullAddress();
    }

    public static String randomGender() {
        String[] gender = new String[]{"Male", "Female", "Other"};
        return getRandomItem(gender);
    }

    public static String randomMonth() {
        String[] month = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return getRandomItem(month);
    }

    public static String randomSubjects() {
        String[] subjects = {"Maths", "Economics", "English", "Biology", "Physics",
                "Chemistry", "Computer Science", "Accounting", "History"};
        return getRandomItem(subjects);
    }

    public static String randomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return getRandomItem(hobbies);
    }

    public static String randomState() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return getRandomItem(state);
    }

    public static String randomCity(String state) {
        if (state.equals("NCR")) {
            String[] cities = {"Delhi", "Gurgaon", "Noida"};
            return getRandomItem(cities);
        }
        if (state.equals("Uttar Pradesh")) {
            String[] cities = {"Agra", "Lucknow", "Merrut"};
            return getRandomItem(cities);
        }
        if (state.equals("Haryana")) {
            String[] cities = {"Karnal", "Panipat"};
            return getRandomItem(cities);
        }
        if (state.equals("Rajasthan")) {
            String[] cities = {"Jaipur", "Jaiselmer"};
            return getRandomItem(cities);
        }
        throw new RuntimeException("hasn't cities for state " + state);
    }

    static String getRandomItem(String[] array) {
        Random random = new Random();
        int index = random.nextInt(array.length);
        return array[index];
    }

}
