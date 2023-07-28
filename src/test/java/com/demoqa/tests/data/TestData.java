package com.demoqa.tests.data;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class TestData {

    String[]
            gender = {"Male", "Female", "Other"},
            subjects = {"Maths", "Accounting", "Arts", "Social Studies", "English", "Chemistry",
            "Computer Science", "Commerce", "Economics", "Social Studies", "Biology", "History"},
            hobbies = {"Sports", "Reading", "Music"},
            state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"},
            cityNCR = {"Delhi", "Gurgaon", "Noida"},
            cityUP = {"Agra", "Lucknow", "Merrut"},
            cityH = {"Karnal", "Panipat"},
            cityR = {"Jaipur", "Jaiselmer"};


    Faker faker = new Faker(new Locale("en"));
    public String
            headerTextPage = "Student Registration Form",
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            fullName = firstName + " " + lastName,
            userEmail = faker.internet().emailAddress(),
            userGender = faker.options().option(gender),
            userPhone = faker.phoneNumber().subscriberNumber(10),
            userPhoto = "pic.jpg",
            userAddress = faker.address().fullAddress(),
            userSubjects = faker.options().option(subjects),
            userHobbies = faker.options().option(hobbies),
            userState = faker.options().option(state);

    Date date = faker.date().birthday(18, 65);
    SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
    public String[] randomDate = formatter.format(date).split(" ");
    public String fullBirthDate = randomDate[0] + " " + randomDate[1] + "," + randomDate[2];

    public String userCity(String value) {
        String city = new String();
        if (Objects.equals(value, "NCR")) {
            city = faker.options().option(cityNCR);
        } else if (Objects.equals(value, "Uttar Pradesh")) {
            city = faker.options().option(cityUP);
        } else if (Objects.equals(value, "Haryana")) {
            city = faker.options().option(cityH);
        } else if (Objects.equals(value, "Rajasthan")) {
            city = faker.options().option(cityR);
        }
        return city;
    }
}
