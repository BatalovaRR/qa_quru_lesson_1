import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests extends TestBase {

@Test
void successfulFillFormTest() {
    open("/automation-practice-form");

    // Ввод имени
    $("[id=firstName]").setValue("firstName");
    // Ввод фамилии
    $("[id=lastName]").setValue("lastName");
    // Ввод почтового ящика
    $("[id=userEmail]").setValue("regress19@gmail.com");
    // Ввод номера телефона
    $("[id=userNumber]").setValue("89274347088");
    // Выбор пола
    $("#genterWrapper").$$("label").findBy(text("Male")).click(); // Мужской
    // Задать дату рождения
    $("[id=dateOfBirthInput]").click();
    $(".react-datepicker__month-select").selectOption("August");
    $(".react-datepicker__year-select").selectOption("1989");
    $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)").click();
    // Ввод предмета
    $("[id=subjectsInput]").setValue("Math");
    $(".subjects-auto-complete__option").click();
    // Выбор хобби
    $("#hobbiesWrapper").$$("label").findBy(text("Sports")).click(); // Спорт
    $("#hobbiesWrapper").$$("label").findBy(text("Music")).click(); // Музыка
    // Загрузить фото
    $("[id=uploadPicture]").uploadFromClasspath("image_3.jpg");
    //Ввод текущего адреса
    $("[id=currentAddress]").setValue("77 Zorge Street");
    // Выбор штата и города
    //Выбор штата
   /* $("[id=state]").click();
    $("[id^=react-select-3-option]").findBy(text("NCR")).click();*/

    //Выбор города
    /*$("[id=city]").click();
    $("[id^=react-select-4-option]").findBy(text("Jaipur")).click();*/

    // Кнопка Submit
    $("[id=submit]").click();

    //Проверка заполненных полей
    $(".table-responsive").shouldHave(text("firstName lastName"));
    $(".table-responsive").shouldHave(text("regress19@gmail.com"));
    $(".table-responsive").shouldHave(text("89274347088"));
    $(".table-responsive").shouldHave(text("Male"));
    $(".table-responsive").shouldHave(text("1 August,1989"));
    $(".table-responsive").shouldHave(text("Math"));
    /*$(".table-responsive").shouldHave(text("Rajasthan"));
    $(".table-responsive").shouldHave(text("Jaipur"));*/
}

    @Test
    void successfulFillRequiredFormTest() {
        open("/automation-practice-form");

        // Ввод имени
        $("[id=firstName]").setValue("firstName");
        // Ввод фамилии
        $("[id=lastName]").setValue("lastName");
        // Ввод номера телефона
        $("[id=userNumber]").setValue("89274347088");
        // Выбор пола
        $("#genterWrapper").$$("label").findBy(text("Male")).click(); // Мужской

        // Кнопка Submit
        $("[id=submit]").click();

        //Проверка заполненных полей
        $(".table-responsive").shouldHave(text("firstName lastName"));
        $(".table-responsive").shouldHave(text("89274347088"));
        $(".table-responsive").shouldHave(text("Male"));
   }


    @Test
    void unsuccessfulEmptyFormTest() {
        open("/automation-practice-form");

        // Кнопка Submit
        $("[id=submit]").click();

        // Модальное окно не появилось
        $(".modal-body").shouldNot(exist);
    }

    @Test
    void unsuccessfulEmptyFirstNameTest() {
        open("/automation-practice-form");


        // Ввод фамилии
        $("[id=lastName]").setValue("lastName");
        // Ввод номера телефона
        $("[id=userNumber]").setValue("89274347088");
        // Выбор пола
        $("#genterWrapper").$$("label").findBy(text("Male")).click(); // Мужской

        // Кнопка Submit
        $("[id=submit]").click();

        // Модальное окно не появилось
        $(".modal-body").shouldNot(exist);
    }

    @Test
    void unsuccessfulInvalidEmailTest() {
        open("/automation-practice-form");

        // Ввод имени
        $("[id=firstName]").setValue("firstName");
        // Ввод фамилии
        $("[id=lastName]").setValue("lastName");
        // Ввод номера телефона
        $("[id=userNumber]").setValue("89274347088");
        // Выбор пола
        $("#genterWrapper").$$("label").findBy(text("Male")).click(); // Мужской
        //Ввод невалидный почтовый адрес
        $("[id=userEmail]").setValue("mail.rу");

        // Кнопка Submit
        $("[id=submit]").click();

        // Модальное окно не появилось
        $(".modal-body").shouldNot(exist);
    }
}
