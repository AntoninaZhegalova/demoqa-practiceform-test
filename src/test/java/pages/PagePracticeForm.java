package pages;

import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PagePracticeForm {

    public PagePracticeForm openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    public PagePracticeForm setFirstName(String value) {
        $("#firstName").setValue(value);
        return this;
    }

    public PagePracticeForm setLastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }

    public PagePracticeForm setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public PagePracticeForm setUserEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }

    public PagePracticeForm setUserNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public PagePracticeForm setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public PagePracticeForm setSubjectsInput(String value) {
        $("#subjectsInput").sendKeys(value);
        $("#subjectsInput").pressEnter();
        return this;
    }

    public PagePracticeForm setHobbiesWrapper(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public PagePracticeForm setUploadPicture(String value) {
        $("#uploadPicture").uploadFromClasspath("picture/avatar.jpg");
        return this;
    }

    public PagePracticeForm setCurrentAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public PagePracticeForm setState(String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }

    public PagePracticeForm setCity(String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }

    public PagePracticeForm pressSubmitButton() {
        $("#submit").click();
        return this;
    }

    public PagePracticeForm checkFormOpened(String value) {
        $("#example-modal-sizes-title-lg").shouldHave(text(value));
        return this;
    }

    public PagePracticeForm checkTable(String key, String value) {
        resultTableComponent.chekResults(key, value);
        return this;
    }
}
