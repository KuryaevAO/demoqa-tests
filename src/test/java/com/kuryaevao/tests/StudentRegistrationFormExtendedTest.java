package com.kuryaevao.tests;

import com.kuryaevao.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.kuryaevao.tests.TestData.*;

public class StudentRegistrationFormExtendedTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillAllFormsExtendedTest() {

        registrationPage.openPage();//открывает страницу и проверяем заголовок
        registrationPage.typeFirstName(firstName);//имя
        registrationPage.typeLastName(lastName);//фамилия
        registrationPage.typeEmail(userEmail);// почта
        registrationPage.selectGender(userGender);// пол
        registrationPage.typePhone(userNumber);// номер телефона
        registrationPage.calendar.setDate("25", "December", "1997");//дата рождения
        registrationPage.selectSubject(subject);// вводим предмет
        registrationPage.selectHobbies(hobby);//хобби
        registrationPage.typeCurrentAddress(currentAddress);//адрес
        registrationPage.selectState(userState);//выбираем штат
        registrationPage.selectCity(userCity);//выбираем город
        registrationPage.submitForm();// отправляем форму

        // сверяем полученные данные
        registrationPage.createdTable.shouldHave(text(firstName + " " + lastName));
        registrationPage.createdTable.shouldHave(text(userEmail));
        registrationPage.createdTable.shouldHave(text(userGender));
        registrationPage.createdTable.shouldHave(text(userNumber));
        registrationPage.createdTable.shouldHave(text("25 December,1997"));
        registrationPage.createdTable.shouldHave(text(subject));
        registrationPage.createdTable.shouldHave(text(hobby));
        registrationPage.createdTable.shouldHave(text(currentAddress));
        registrationPage.createdTable.shouldHave(text(userState + " " + userCity));
    }
}
