package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class TestPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void shouldHaveFilledFieldsInModalBody() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

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

        $("input[id='firstName']").setValue(firstName);
        $("input[id='lastName']").setValue(lastName);

        $(byText("Male")).click();

        $("input[id='userEmail']").setValue(userEmail);
        $("input[id='userNumber']").setValue(userNumber);

        $("#dateOfBirthInput").click();

        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--022").click();

        $("#subjectsInput").sendKeys("S");
        $(byText("Social Studies")).click();

        $(byText(reading)).click();

        $("#uploadPicture").uploadFromClasspath("picture/" + avatarPicture);

        $("textarea[id='currentAddress']").setValue(currentAddress);

        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();


        $("[id=submit]").click();


        $("[class=modal-body]")
                .shouldHave(
                        text(firstName), text(lastName), text(userEmail), text(userNumber), text(dateOfBirthInput),
                        text(subjectsContainer), text(reading), text(avatarPicture), text(currentAddress),
                        text(state), text(city)
                );
    }

}