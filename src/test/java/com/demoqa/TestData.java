package com.demoqa;

import utils.RandomData;

public class TestData {

    public static final String FIRST_NAME = RandomData.getFirstName(),
            LAST_NAME = RandomData.getLastName(),
            GENDER = RandomData.randomGender(),
            USER_MAIL = RandomData.getUserMail(),
            USER_NUMBER = RandomData.getUserNumber(),
            DAY = RandomData.getDay(),
            MONTH = RandomData.randomMonth(),
            YEAR = RandomData.getYear(),
            SUBJECTS_INPUT = RandomData.randomSubjects(),
            HOBBIES = RandomData.randomHobbies(),
            CURRENT_ADDRESS = RandomData.getCurrentAddress(),
            STATE = RandomData.randomState(),
            CITY = RandomData.randomCity(STATE),
            AVATAR_PICTURE = "avatar.jpg",
            CHECK_FORM_TEXT = "Thanks for submitting the form";
}
