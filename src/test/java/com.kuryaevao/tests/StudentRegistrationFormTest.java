package com.kuryaevao.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.browserSize = "3840×2160";
        Configuration.pageLoadTimeout = 600000;
    }

    @Test
    void fillAllFormsTest(){
        // объявляем переменные для удобства
        String firstName = "Alexandr";
        String lastName = "Kuryaev";
        String userEmail = "a.kuryaev@mail.ru";
        String userNumber = "9876543211";
        String subject = "Maths";
        String currentAddress = "Saransk";
        String userState = "NCR";
        String userCity = "Delhi";

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);// имя
        $("#lastName").setValue(lastName);// фамилия
        $("#userEmail").setValue(userEmail);// почта
        $(By.cssSelector("label[for='gender-radio-1']")).click();// пол
        $("#userNumber").setValue(userNumber);// номер телефона
        $("#dateOfBirthInput").sendKeys(Keys.END); // перемещаем курсор в конец поля ввода даты рождения
        $("#dateOfBirthInput").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME)); // выделяем текущее значение поля ввода
        $("#dateOfBirthInput").sendKeys("25 Dec 1997"); // вводим новое значение
        $("#dateOfBirthInput").pressEnter();// сохраняем значение
        $("#subjectsInput").setValue(subject).pressEnter();// вводим предмет
        $(By.cssSelector("label[for='hobbies-checkbox-1']")).click();
        $("#currentAddress").setValue(currentAddress);// адрес
        $("#react-select-3-input").setValue(userState).pressEnter();// вводим штат и сохраняем
        $("#react-select-4-input").setValue(userCity).pressEnter().pressEnter();// вводим город, сохраняем и отправляем форму

        System.out.println($(byClassName("table-responsive")));//выводим в консоль

        // сверяем полученные данные
        $(byClassName("table-responsive")).shouldHave(text(firstName+" "+ lastName));
        $(byClassName("table-responsive")).shouldHave(text(userEmail));
        $(byClassName("table-responsive")).shouldHave(text("Male"));
        $(byClassName("table-responsive")).shouldHave(text(userNumber));
        $(byClassName("table-responsive")).shouldHave(text("25 December,1997"));
        $(byClassName("table-responsive")).shouldHave(text(subject));
        $(byClassName("table-responsive")).shouldHave(text("Sports"));
        $(byClassName("table-responsive")).shouldHave(text(currentAddress));
        $(byClassName("table-responsive")).shouldHave(text(userState + " " + userCity));
    }
}
