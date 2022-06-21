package com.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class TestPracticeForm extends TestBase {

    @Test
    void shouldHaveFilledFieldsInModalBody() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        String firstName = "Ivan";
        String lastName = "Petrov";
        String userEmail = "ip@gmail.com";
        String userNumber = "9219219191";
        String dateOfBirthInput = "22 June,1990";
        String subjectsContainer = "Social Studies";
        String currentAddress = "Rubinshteina,23";
        String state = "NCR";
        String city = "Gurgaon";
        String reading = "Reading";
        String avatarPicture = "avatar.jpg";

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userEmail").setValue(userEmail);
        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--022:not(react-datepicker__day--outside-month)").click();

        $("#subjectsInput").sendKeys("Social");
        $("#subjectsInput").pressEnter();

        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("picture/avatar.jpg");
        $("#currentAddress").setValue(currentAddress);

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Gurgaon")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        checkTable("Date of Birth", dateOfBirthInput);

    }

    void checkTable(String key, String value) {
        $(".table-responsive").$(byText(key))
                .parent().shouldHave(text(value));
    }

}