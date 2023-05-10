package com.kuryaevao.tests;

import com.kuryaevao.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.kuryaevao.tests.TestData.*;

public class StudentRegistrationFormExtendedTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillAllFormsExtendedTest() {

        registrationPage.openPage();//открывает страницу и проверяем заголовок
        registrationPage.typeFirstName(firstName);//имя
        registrationPage.typeLastName(lastName);//фамилия
        registrationPage.typeEmail(userEmail);// почта
        $(By.cssSelector("label[for='gender-radio-1']")).click();// пол
        registrationPage.typePhone(userNumber);// номер телефона
        registrationPage.calendar.setDate("25", "December", "1997");//дата рождения
        $("#subjectsInput").setValue(subject).pressEnter();// вводим предмет
        $(By.cssSelector("label[for='hobbies-checkbox-1']")).click();//хобби
        registrationPage.typeCurrentAddress(currentAddress);//адрес
        $("#state").scrollTo().click();//открываем штаты
        $("#stateCity-wrapper").$(byText(userState)).click();//выбираем штат
        $("#city").click();//открываем города
        $("#stateCity-wrapper").$(byText(userCity)).click();//выбираем город
        $("#submit").scrollTo().pressEnter();// отправляем форму

        // сверяем полученные данные
        registrationPage.createdTable.shouldHave(text(firstName + " " + lastName));
        registrationPage.createdTable.shouldHave(text(userEmail));
        registrationPage.createdTable.shouldHave(text("Male"));
        registrationPage.createdTable.shouldHave(text(userNumber));
        registrationPage.createdTable.shouldHave(text("25 December,1997"));
        registrationPage.createdTable.shouldHave(text(subject));
        registrationPage.createdTable.shouldHave(text("Sports"));
        registrationPage.createdTable.shouldHave(text(currentAddress));
        registrationPage.createdTable.shouldHave(text(userState + " " + userCity));
    }
}
