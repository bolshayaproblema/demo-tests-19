package com.demoqa.tests;


import org.junit.jupiter.api.Test;


public class PracticeFormTests extends TestBase {

    @Test
    void successfulPracticeFormTests() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Ivan")
                .setLastName("Petrov")
                .setUserEmail("ivanpetrov@mail.com")
                .setGender("Male")
                .setNumber("9999999999")
                .setBerthDate("02", "July", "1995")
                .setSubjects("Physics")
                .setHobbies("Sports")
                .setPicture("1.png")
                .setAddress("Moscow")
                .setState("Uttar Pradesh")
                .setCity("Lucknow")
                .clickSubmit();

        registrationPage.verifyResult("Student Name", "Ivan Petrov")
                .verifyResult("Student Email", "ivanpetrov@mail.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "9999999999")
                .verifyResult("Date of Birth", "02 July,1995")
                .verifyResult("Subjects", "Physics")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "1.png")
                .verifyResult("Address", "Moscow")
                .verifyResult("State and City", "Uttar Pradesh Lucknow");


    }
}