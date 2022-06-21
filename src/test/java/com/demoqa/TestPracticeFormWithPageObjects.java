package com.demoqa;

import org.junit.jupiter.api.Test;
import pages.PagePracticeForm;

import static com.demoqa.TestData.*;


public class TestPracticeFormWithPageObjects extends TestBase {

    @Test
    void shouldHaveFilledFieldsInModalBody() {

        PagePracticeForm pagePracticeForm = this.pagePracticeForm.openPage()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGender(GENDER)
                .setUserEmail(USER_MAIL)
                .setUserNumber(USER_NUMBER)
                .setDateOfBirth(DAY, MONTH, YEAR)
                .setSubjectsInput(SUBJECTS_INPUT)
                .setHobbiesWrapper(HOBBIES)
                .setUploadPicture(AVATAR_PICTURE)
                .setCurrentAddress(CURRENT_ADDRESS)
                .setState(STATE)
                .setCity(CITY);

        pagePracticeForm
                .pressSubmitButton();

        pagePracticeForm
                .checkFormOpened(CHECK_FORM_TEXT)
                .checkTable("Student Name", FIRST_NAME)
                .checkTable("Student Name", LAST_NAME)
                .checkTable("Student Email", USER_MAIL)
                .checkTable("Gender", GENDER)
                .checkTable("Mobile", USER_NUMBER)
                .checkTable("Date of Birth", DAY)
                .checkTable("Date of Birth", MONTH)
                .checkTable("Date of Birth", YEAR)
                .checkTable("Subjects", SUBJECTS_INPUT)
                .checkTable("Hobbies", HOBBIES)
                .checkTable("Picture", AVATAR_PICTURE)
                .checkTable("Address", CURRENT_ADDRESS)
                .checkTable("State and City", STATE + " " + CITY);

    }
}