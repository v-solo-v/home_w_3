import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    @BeforeAll
    public static void beforeAllMethod() {
        Configuration.browserSize = System.getProperty("browserSize","1920x1080");
        Configuration.browser = System.getProperty("browser", "firefox");
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/automation-practice-form");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
    }
    @Test
    void automationPracticeForm () {
        $("#firstName").setValue("Diego");
        $("#lastName").setValue("Maradona");
        $("#userEmail").setValue("special_one@gmail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9991112233");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("March")).click();
        $(".react-datepicker__year-dropdown-container").$(byText("1960")).click();
        $(".react-datepicker__day--0" + "30" + ":not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Commerce").pressEnter();
        $("#hobbies-checkbox-1").parent().$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("myfoto.jpg");
        $("#currentAddress").setValue("Lanus, Buenos Aires, Argentina");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();
        $("#submit").click();
        $(".modal-content").should(appear);
        $(".modal-open").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Diego Maradona"));
        $(".modal-body").shouldHave(text("special_one@gmail.ru"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("9991112233"));
        $(".modal-body").shouldHave(text("30 March,1960"));
        $(".modal-body").shouldHave(text("Commerce"));
        $(".modal-body").shouldHave(text("Sports"));
        $(".modal-body").shouldHave(text("Lanus, Buenos Aires, Argentina"));
        $(".modal-body").shouldHave(text("Haryana Panipat"));
        $("#closeLargeModal").click();
    }
}
