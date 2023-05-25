package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import static com.demoqa.tests.TestData.*;

public class RandomUtils {


    public static String getRandomString(int len) {
        // String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();


        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
    private static Faker faker = new Faker();
    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    public static String getRandomCity(String state) {
        String city;
        switch (state) {
            case "NCR": {
                city = faker.options().option(stateNCR);
                return city;
            }
            case "Uttar Pradesh": {
                city = faker.options().option(stateUttarPradesh);
                return city;
            }
            case "Haryana": {
                city = faker.options().option(stateHaryana);
                return city;
            }
            case "Rajasthan": {
                city = faker.options().option(stateRajasthan);
                return city;
            }
        }
        return null;
    }

}





