package com.demoqa.oldTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.CONTROL;


public class OldPracticeFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1900 × 1000";
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
    }


    @Test
    void successfulPracticeFormTests() {

        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("ivanpetrov@mail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9999999999");
        $("#dateOfBirthInput").sendKeys(CONTROL + "A");
        $("#dateOfBirthInput").sendKeys("1995.07.02");
        $("#dateOfBirthInput").pressEnter();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("1.png");
        $("#currentAddress").setValue("Moscow");
        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Lucknow")).click();
        $("#submit").click();


        $(".table-responsive").shouldHave(text("Ivan Petrov"),
                text("ivanpetrov@mail.com"),
                text("Male"),
                text("9999999999"),
                text("02 July,1995"),
                text("Physics"),
                text("Sports"),
                text("1.png"),
                text("Moscow"),
                text("Uttar Pradesh Lucknow"));


    }
}