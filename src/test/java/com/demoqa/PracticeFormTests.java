package com.demoqa;


import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;



import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.CONTROL;


public class PracticeFormTests extends PracticeForm {

    @Test
    void seccessfullPracticeFormTests() {

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("ivanpetrov@mail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9999999999");
        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").sendKeys(CONTROL + "A");
        $("#dateOfBirthInput").sendKeys("1995.07.02");
        $("#dateOfBirthInput").pressEnter();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("1.png");
        $("#currentAddress").setValue("City Moscow, Lenin street");
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
                text("City Moscow,Lenin street"),
                text("Uttar Pradesh Lucknow"));


    }
}