package pages;

import com.beust.jcommander.IValueValidator;
import pages.components.CalendarComponent;

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

    public PagePracticeForm setFirstName(String value) {
        $("#firstName").setValue(value);
        return this;
    }

    public PagePracticeForm setLastName(String value) {

        $("#lastName").setValue(value);
        return this;
    }

    public PagePracticeForm setGender(String value) {

        $("#genterWrapper").$(byText("Male")).click();
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
}
