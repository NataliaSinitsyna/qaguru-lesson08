package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.tests.data.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class RegistrationFormWithTestDataTests extends RemoteTestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();
    @Test
    @Tag("remote")
    @DisplayName("Successful registration")
    void successfulFillFormTest() {

        step("Открыть и заполнить форму", () -> {
            registrationPage.openPage(testData.headerTextPage)
                    .removeBanners()
                    .setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setUserEmail(testData.userEmail)
                    .setGender(testData.userGender)
                    .setUserNumber(testData.userPhone)
                    .setBirthDate(testData.randomDate[0], testData.randomDate[1], testData.randomDate[2])
                    .setUserSubject(testData.userSubjects)
                    .setUserHobbies(testData.userHobbies)
                    .uploadPicture(testData.userPhoto)
                    .setAddress(testData.userAddress)
                    .setState(testData.userState)
                    .setCity(testData.userCity(testData.userState))
                    .submit();
        });

        step("Проверить заполненные значения", () -> {
            registrationPage.verifyRegistrationResultModalAppears()
                    .verifyResult("Student Name", testData.fullName)
                    .verifyResult("Student Email", testData.userEmail)
                    .verifyResult("Gender", testData.userGender)
                    .verifyResult("Mobile", testData.userPhone)
                    .verifyResult("Date of Birth", testData.fullBirthDate)
                    .verifyResult("Subjects", testData.userSubjects)
                    .verifyResult("Hobbies", testData.userHobbies)
                    .verifyResult("Picture", testData.userPhoto)
                    .verifyResult("Address", testData.userAddress)
                    .verifyResult("State and City", testData.userState + " " + testData.userCity(testData.userState));
        });
    }
}