package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.demoqa.utils.RandomUtils.*;
import static org.openqa.selenium.Keys.CONTROL;


public class RegistrationWithRandomUtilsOldTests extends TestBase {



    @Test
    void successfulPracticeFormTests() {
        String firsName = getRandomString(10),
                lastName = getRandomString(10),
                userEmail = getRandomEmail();



        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        $("#firstName").setValue(firsName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(getRandomGander())).click();
        $("#userNumber").setValue(getRandomInt(1111111111,999999999) + "");
        // $("#userNumber").setValue("+7 (" + getRandomInt(111, 999) + ")" + getRandomInt(1111,9999) + " - " + getRandomInt(111,999));
        // $("#userNumber").setValue(getRandomPhone());
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

        $(".table-responsive").shouldHave(text(firsName), text((lastName)),
                text(userEmail),
                text((getRandomGander())),
                text("9999999999"),
                text("02 July,1995"),
                text("Physics"),
                text("Sports"),
                text("1.png"),
                text("Moscow"),
                text("Uttar Pradesh Lucknow"));


    }
}