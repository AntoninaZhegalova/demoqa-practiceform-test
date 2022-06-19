package pages;

import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PagePracticeFormWithRandomUtils {

    public PagePracticeFormWithRandomUtils openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    public PagePracticeFormWithRandomUtils setFirstName(String value) {
        $("#firstName").setValue(value);
        return this;
    }

    public PagePracticeFormWithRandomUtils setLastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }

    public PagePracticeFormWithRandomUtils setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public PagePracticeFormWithRandomUtils setUserEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }

    public PagePracticeFormWithRandomUtils setUserNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public PagePracticeFormWithRandomUtils setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public PagePracticeFormWithRandomUtils setSubjectsInput(String value) {
        $("#subjectsInput").sendKeys(value);
        $("#subjectsInput").pressEnter();
        return this;
    }

    public PagePracticeFormWithRandomUtils setHobbiesWrapper(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public PagePracticeFormWithRandomUtils setUploadPicture(String value) {
        $("#uploadPicture").uploadFromClasspath("picture/avatar.jpg");
        return this;
    }

    public PagePracticeFormWithRandomUtils setCurrentAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public PagePracticeFormWithRandomUtils setState(String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }

    public PagePracticeFormWithRandomUtils setCity(String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }

    public PagePracticeFormWithRandomUtils pressSubmitButton() {
        $("#submit").click();
        return this;
    }

    public PagePracticeFormWithRandomUtils checkFormOpened(String value) {
        $("#example-modal-sizes-title-lg").shouldHave(text(value));
        return this;
    }

    public PagePracticeFormWithRandomUtils checkTable(String key, String value) {
        resultTableComponent.chekResults(key, value);
        return this;
    }
}
