import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests extends TestBase {

@Test
void successfulFillFormTest() {
    open("/automation-practice-form");

    $("[id=firstName]").setValue("firstName");
    $("[id=firstName]").setValue("DDDooooouuuublefirstNamettteee");
    $("[id=firstName]").setValue("TxxTThirdfirstName");
    $("[id=lastName]").setValue("lastName");
    $("[id=userEmail]").setValue("regress19@gmail.com");
    $("[id=userNumber]").setValue("9274347088");
    $("#genterWrapper").$(byText("Male")).click();

    $("[id=dateOfBirthInput]").click();
    $(".react-datepicker__month-select").selectOption("August");
    $(".react-datepicker__year-select").selectOption("1989");
    $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)").click();

    $("[id=subjectsInput]").setValue("Math");
    $(".subjects-auto-complete__option").click();

    $("#hobbiesWrapper").$(byText("Sports")).click();
    $("#hobbiesWrapper").$(byText("Music")).click();

    $("[id=uploadPicture]").uploadFromClasspath("image_3.jpg");
    $("[id=currentAddress]").setValue("77 Zorge Street");

    $("#state").click();
    $("#react-select-3-input").setValue("NCR").pressEnter();

    $("#city").click();
    $("#react-select-4-input").setValue("Delhi").pressEnter();

    $("[id=submit]").click();


    $(".table-responsive").shouldHave(text("firstName lastName"));
    $(".table-responsive").shouldHave(text("regress19@gmail.com"));
    $(".table-responsive").shouldHave(text("9274347088"));
    $(".table-responsive").shouldHave(text("Male"));
    $(".table-responsive").shouldHave(text("1 August,1989"));
    $(".table-responsive").shouldHave(text("Math"));
    $(".table-responsive").shouldHave(text("NCR"));
    $(".table-responsive").shouldHave(text("Delhi"));
    $(".table-responsive").shouldHave(text("image_3.jpg"));
}

    @Test
    void successfulFillRequiredFormTest() {
        open("/automation-practice-form");

        $("[id=firstName]").setValue("firstName");
        $("[id=lastName]").setValue("lastName");
        $("[id=userNumber]").setValue("9274347088");
        $("#genterWrapper").$(byText("Male")).click();


        $("[id=submit]").click();

        $(".table-responsive").shouldHave(text("firstName lastName"));
        $(".table-responsive").shouldHave(text("9274347088"));
        $(".table-responsive").shouldHave(text("Male"));
   }


    @Test
    void unsuccessfulEmptyFormTest() {
        open("/automation-practice-form");

        $("[id=submit]").click();

        $(".modal-body").shouldNot(exist);
    }

    @Test
    void unsuccessfulEmptyFirstNameTest() {
        open("/automation-practice-form");

        $("[id=lastName]").setValue("lastName");
        $("[id=userNumber]").setValue("9274347088");
        $("#genterWrapper").$(byText("Male")).click();

        $("[id=submit]").click();

        $(".modal-body").shouldNot(exist);
    }

    @Test
    void unsuccessfulEmptyLastNameTest() {
        open("/automation-practice-form");

        $("[id=firstName]").setValue("firstName");
        $("[id=userNumber]").setValue("9274347088");
        $("#genterWrapper").$(byText("Male")).click();

        $("[id=submit]").click();

        $(".modal-body").shouldNot(exist);
    }

    @Test
    void unsuccessfulEmptyUserNumberTest() {
        open("/automation-practice-form");

        $("[id=lastName]").setValue("lastName");
        $("[id=lastName]").setValue("firstName");
        $("#genterWrapper").$(byText("Male")).click();

        $("[id=submit]").click();

        $(".modal-body").shouldNot(exist);
    }

    @Test
    void unsuccessfulEmptyMaleTest() {
        open("/automation-practice-form");

        $("[id=lastName]").setValue("lastName");
        $("[id=lastName]").setValue("firstName");
        $("[id=userNumber]").setValue("9274347088");

        $("[id=submit]").click();

        $(".modal-body").shouldNot(exist);
    }

    @Test
    void unsuccessfulInvalidEmailTest() {
        open("/automation-practice-form");

        $("[id=firstName]").setValue("firstName");
        $("[id=lastName]").setValue("lastName");
        $("[id=userNumber]").setValue("9274347088");
        $("#genterWrapper").$(byText("Male")).click();
        $("[id=userEmail]").setValue("mail.rу");

        $("[id=submit]").click();

        $(".modal-body").shouldNot(exist);
    }
}
