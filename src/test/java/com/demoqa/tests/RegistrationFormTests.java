package com.demoqa.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests extends TestBase {

    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Test");
        $("#lastName").setValue("Test");
        $("#userEmail").setValue("test@test.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("79999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("7");
        $(".react-datepicker__year-select").selectOptionByValue("1955");
        $$(".react-datepicker__day.react-datepicker__day--005").first().click();
        $("#subjectsInput").setValue("Che");
        $(byText("Chemistry")).click();
        $(byText("Reading")).click();
        File file = new File("src/test/resources/pic.jpg");
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue("Moscow 17");
        $("#state").click();
        sleep(500);
        $(byText("Haryana")).click();
        $("#city").click();
        sleep(500);
        $(byText("Karnal")).click();
        $("#submit").click();

        $(".modal-header").shouldHave(Condition.text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(Condition.text("Test Test"), Condition.text("test@test.com"),
                Condition.text("Male"), Condition.text("7999999999"), Condition.text("05 August,1955"),
                Condition.text("Chemistry"), Condition.text("Reading"), Condition.text("pic.jpg"),
                Condition.text("Moscow 17"), Condition.text("Haryana Karnal"));

    }

}