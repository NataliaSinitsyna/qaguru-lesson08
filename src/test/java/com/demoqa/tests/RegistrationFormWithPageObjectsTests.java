package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void successfulFillFormTest() {

        registrationPage.openPage("Student Registration Form")
                        .removeBanners()
                        .setFirstName("Test")
                        .setLastName("Test")
                        .setUserEmail("test@test.com")
                        .setGender("Male")
                        .setUserNumber("79999999999")
                        .setBirthDate("05", "August", "1955")
                        .setUserSubject("Chemistry")
                        .setUserHobbies("Reading")
                        .uploadPicture("pic.jpg")
                        .setAddress("Moscow 17")
                        .setState("Haryana")
                        .setCity("Karnal")
                        .submit();

        registrationPage.verifyRegistrationResultModalAppears()
                        .verifyResult("Student Name", "Test Test")
                        .verifyResult("Student Email", "test@test.com")
                        .verifyResult("Gender", "Male")
                        .verifyResult("Mobile", "7999999999")
                        .verifyResult("Date of Birth", "05 August,1955")
                        .verifyResult("Subjects", "Chemistry")
                        .verifyResult("Hobbies", "Reading")
                        .verifyResult("Picture", "pic.jpg")
                        .verifyResult("Address", "Moscow 17")
                        .verifyResult("State and City", "Haryana Karnal");

    }

}