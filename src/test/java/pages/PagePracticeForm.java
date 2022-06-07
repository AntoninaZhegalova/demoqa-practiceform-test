package pages;

import com.beust.jcommander.IValueValidator;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PagePracticeForm {

    public void setFirstName(String value) {
        $("#firstName").setValue(value);
    }

    public void setLastName(String value) {
        $("#lastName").setValue(value);
    }

    public void setGender(String value) {
        $("#genterWrapper").$(byText("Male")).click();
    }

    public void setUserEmail(String value) {
        $("#userEmail").setValue(value);
    }
    public void setUserNumber(String value) {
        $("#userNumber").setValue(value);
    }
}
