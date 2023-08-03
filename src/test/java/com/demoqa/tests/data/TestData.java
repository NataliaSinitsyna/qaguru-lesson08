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
            presentState = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};


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
            state = faker.options().option(presentState);

    Date date = faker.date().birthday(18, 65);
    SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
    public String[] randomDate = formatter.format(date).split(" ");
    public String fullBirthDate = randomDate[0] + " " + randomDate[1] + "," + randomDate[2];

    public String getCity() {
        String city = new String();
        if (Objects.equals(state, "NCR")) {
            String[] cityNCR = {"Delhi", "Gurgaon", "Noida"};
            city = faker.options().option(cityNCR);
        } else if (Objects.equals(state, "Uttar Pradesh")) {
            String[] cityUP = {"Agra", "Lucknow", "Merrut"};
            city = faker.options().option(cityUP);
        } else if (Objects.equals(state, "Haryana")) {
            String[] cityH = {"Karnal", "Panipat"};
            city = faker.options().option(cityH);
        } else if (Objects.equals(state, "Rajasthan")) {
            String[] cityR = {"Jaipur", "Jaiselmer"};
            city = faker.options().option(cityR);
        }

        return city;
    }
    public String[] fullAddress = new String[]{state, getCity()};
    public String userState = fullAddress[0];
    public String userCity = fullAddress[1];
}
