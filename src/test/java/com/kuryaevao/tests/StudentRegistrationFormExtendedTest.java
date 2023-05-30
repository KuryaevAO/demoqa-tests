package com.kuryaevao.tests;

import com.kuryaevao.pages.RegistrationPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.kuryaevao.tests.TestData.*;

public class StudentRegistrationFormExtendedTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("testBaseTest")
    void fillAllFormsExtendedTest() {

        registrationPage.openPage();//открываем страницу
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

        registrationPage.createTable();//сравниваем итоговую таблицу с данными
    }
}
