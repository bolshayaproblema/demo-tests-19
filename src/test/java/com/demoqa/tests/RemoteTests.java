package com.demoqa.tests;


import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;
import static com.demoqa.utils.RandomUtils.getRandomCity;
import static com.demoqa.utils.RandomUtils.getRandomInt;


public class RemoteTests extends RemoteTestBase {

    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
    lastName = faker.name().lastName(),
    userEmail = faker.internet().emailAddress(),
    userGender = faker.options().option(TestData.gender),
    userPhone = 89 + faker.phoneNumber().subscriberNumber(8),
    dayOfBirth = String.format("%02d", faker.number().numberBetween(1, 25)),
    monthOfBirth = faker.options().option(months),
    yearOfBirth = String.valueOf(getRandomInt(1943, 2001)),
    subject = faker.options().option(subjects),
    hobbies = faker.options().option(TestData.hobbies),
    picture = faker.options().option(TestData.picture),
    address = faker.address().streetAddress(),
    sates = faker.options().option(states),
    city = getRandomCity(sates);


    @Test
    @Tag("remote")
    void successfulPracticeFormTests() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setNumber(userPhone)
                .setBerthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subject)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setAddress(address)
                .setState(sates)
                .setCity(city)
                .clickSubmit();

        registrationPage.verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userPhone)
                .verifyResult("Date of Birth",  dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", picture)
                .verifyResult("Address", address)
                .verifyResult("State and City", sates + " " + city);


    }
}