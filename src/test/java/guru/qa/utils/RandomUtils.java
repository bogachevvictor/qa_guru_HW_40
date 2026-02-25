package guru.qa.utils;


import com.github.javafaker.Faker;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    private static final Random RANDOM = new Random();
    private static final Faker FAKER = new Faker();

    private static final Map<String, String[]> STATE_CITIES = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );

    private static String getRandomElement(String[] array) {
        return array[RANDOM.nextInt(array.length)];
    }

    public static String getRandomFirstName() {
        return FAKER.name().firstName();
    }

    public static String getRandomLastName() {
        return FAKER.name().lastName();
    }

    public static String getRandomEmail() {
        return FAKER.internet().emailAddress();
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomElement(genders);
    }

    public static String getRandomPhone() {
        return String.format("%s%s%s%s",getRandomInt(111, 999), getRandomInt(111, 999), getRandomInt(11, 99), getRandomInt(11, 99));
    }

    public static String getRandomSubjects() {
        String[] subjects = {"Hindi", "English", "Maths", "Physics", "Chemistry", "Biology", "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics"};
        return getRandomElement(subjects);
    }

    public static String getRandomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return getRandomElement(hobbies);
    }

    public static String getRandomCurrentAddress() {
        return FAKER.address().streetAddress();
    }

    public static String getRandomState() {
        return getRandomElement(STATE_CITIES.keySet().toArray(String[]::new));
    }

    public static String getRandomCity(String state) {
        String[] cities = STATE_CITIES.get(state);
        if (cities == null) {
            throw new IllegalArgumentException("Неизвестный штат: " + state);
        }
        return getRandomElement(cities);
    }

    public static String formatDayWithLeadingZero(int day) {
        return String.format("%02d", day);
    }
}
