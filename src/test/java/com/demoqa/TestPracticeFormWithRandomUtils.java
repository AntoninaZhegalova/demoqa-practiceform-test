package com.demoqa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PagePracticeForm;

import static com.demoqa.TestData.*;
import static io.qameta.allure.Allure.step;


public class TestPracticeFormWithRandomUtils extends TestBase {

    @Test
    @DisplayName("Форма регистрации для студенов: Проверка заполнения рандомными данными")
    void shouldHaveFilledFieldsInModalBody() {

        step("Шаг 1: Открываем форму регистрации", () -> {
            PagePracticeForm pagePracticeForm = this.pagePracticeForm.openPage();
        });

        step("Шаг 2: Заполняем форму регистрации", () -> {
            PagePracticeForm pagePracticeForm = this.pagePracticeForm.setFirstName(FIRST_NAME)
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
        });

        step("Шаг 3: Проверяем соответствие содержания полей формы данными из шага 2", () -> {

            PagePracticeForm pagePracticeForm = this.pagePracticeForm.checkFormOpened(CHECK_FORM_TEXT)
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
        });

    }
}
