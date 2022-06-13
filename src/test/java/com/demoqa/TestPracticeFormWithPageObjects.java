package com.demoqa;

import org.junit.jupiter.api.Test;
import pages.PagePracticeForm;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.demoqa.TestData.*;


public class TestPracticeFormWithPageObjects extends TestBase {

    @Test
    void shouldHaveFilledFieldsInModalBody() {

        this.pagePracticeForm.openPage()
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
                .setCity(CITY)
                .pressSubmitButton()
                .checkFormOpened(CHECK_FORM_TEXT);
//                .checkResult();

//        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(userEmail),
//                text(userNumber), text(dateOfBirthInput), text(subjectsContainer), text(reading),
//                text(avatarPicture), text(currentAddress), text(state), text(city));

//        $(".table-responsive").$(byText("Date of Birth")).parent()
//                .shouldHave(text(dateOfBirthInput));

//        checkTable("Date of Birth", dateOfBirthInput);

    }

//    void checkTable(String key, String value) {
//        $(".table-responsive").$(byText(key))
//                .parent().shouldHave(text(value));
//    }

}