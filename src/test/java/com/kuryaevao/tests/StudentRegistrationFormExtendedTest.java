package com.kuryaevao.tests;

import com.kuryaevao.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.kuryaevao.tests.TestData.*;
import static io.qameta.allure.Allure.step;

public class StudentRegistrationFormExtendedTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillAllFormsExtendedTest() {

        step("Открывает страницу и проверяем заголовок", () -> {
            registrationPage.openPage();//открываем страницу
        });
        step("Вводим имя", () -> {
            registrationPage.typeFirstName(firstName);//имя
        });
        step("Вводим фамилию", () -> {
            registrationPage.typeLastName(lastName);//фамилия
        });
        step("Вводим почту", () -> {
            registrationPage.typeEmail(userEmail);// почта
        });
        step("Вводим пол", () -> {
            registrationPage.selectGender(userGender);// пол
        });
        step("Вводим номер телефона", () -> {
            registrationPage.typePhone(userNumber);// номер телефона
        });
        step("Вводим дату рождения", () -> {
            registrationPage.calendar.setDate("25", "December", "1997");//дата рождения
        });
        step("Вводим предмет", () -> {
            registrationPage.selectSubject(subject);// вводим предмет
        });
        step("Вводим хобби", () -> {
            registrationPage.selectHobbies(hobby);//хобби
        });
        step("Вводим текущий адрес", () -> {
            registrationPage.typeCurrentAddress(currentAddress);//адрес
        });
        step("Вводим штат", () -> {
            registrationPage.selectState(userState);//выбираем штат
        });
        step("Вводим город", () -> {
            registrationPage.selectCity(userCity);//выбираем город
        });
        step("Отправляем форму", () -> {
            registrationPage.submitForm();// отправляем форму
        });

        step("Сверяем введенные данные с полученной таблицей", () -> {
            registrationPage.createdTable.shouldHave(text(firstName + " " + lastName));
            registrationPage.createdTable.shouldHave(text(userEmail));
            registrationPage.createdTable.shouldHave(text(userGender));
            registrationPage.createdTable.shouldHave(text(userNumber));
            registrationPage.createdTable.shouldHave(text("25 December,1997"));
            registrationPage.createdTable.shouldHave(text(subject));
            registrationPage.createdTable.shouldHave(text(hobby));
            registrationPage.createdTable.shouldHave(text(currentAddress));
            registrationPage.createdTable.shouldHave(text(userState + " " + userCity));
        });
    }
}
