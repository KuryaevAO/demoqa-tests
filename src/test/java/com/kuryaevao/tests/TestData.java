package com.kuryaevao.tests;

import com.github.javafaker.Faker;

public class TestData {

    static Faker faker = new Faker();

    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.pokemon().name() + "@gmail.com",
            userNumber = faker.phoneNumber().subscriberNumber(10),
            subject = "Maths",
            currentAddress = faker.twinPeaks().location(),
            userState = "NCR",
            userCity = "Delhi";
}
