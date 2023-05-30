package com.kuryaevao.pages;

import com.codeborne.selenide.SelenideElement;
import com.kuryaevao.pages.components.CalendarComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.kuryaevao.tests.TestData.*;

public class RegistrationPage {

    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            phoneInput = $("#userNumber"),
            currentAddressInput = $("#currentAddress"),
            subjectInput = $("#subjectsInput"),
            hobbieWrapper = $("#hobbiesWrapper"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            stateCityWrapper = $("#stateCity-wrapper"),
            submitInput = $("#submit");

    public CalendarComponent calendar = new CalendarComponent();

    @Step("Открытие страницы и проверка заголовка")
    public void openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    @Step("Ввод имени")
    public void typeFirstName(String value) {
        firstNameInput.setValue(value);
    }

    @Step("Ввод фамилии")
    public void typeLastName(String value) {
        lastNameInput.setValue(value);
    }

    @Step("Ввод почты")
    public void typeEmail(String value) {
        emailInput.setValue(value);
    }

    @Step("Ввод номера телефона")
    public void typePhone(String value) {
        phoneInput.setValue(value);
    }

    @Step("Ввод текущего адрес")
    public void typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
    }

    @Step("Ввод пола")
    public void selectGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
    }

    @Step("Ввод предмета")
    public void selectSubject(String value) {
        subjectInput.setValue(value).pressEnter();
    }

    @Step("Ввод хобби")
    public void selectHobbies(String value) {
        hobbieWrapper.$(byText(value)).click();
    }

    @Step("Ввод штата")
    public void selectState(String value) {
        stateInput.scrollTo().click();
        stateCityWrapper.$(byText(value)).click();
    }

    @Step("Ввод города")
    public void selectCity(String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();
    }

    @Step("Отправка формы")
    public void submitForm() {
        submitInput.scrollTo().pressEnter();
    }

    @Step("Сверка введенных данных с полученной таблицей")
    public void createTable() {
        SelenideElement createdTable = $(byClassName("table-responsive"));

        createdTable.shouldHave(text(firstName + " " + lastName));
        createdTable.shouldHave(text(userEmail));
        createdTable.shouldHave(text(userGender));
        createdTable.shouldHave(text(userNumber));
        createdTable.shouldHave(text("25 December,1997"));
        createdTable.shouldHave(text(subject));
        createdTable.shouldHave(text(hobby));
        createdTable.shouldHave(text(currentAddress));
        createdTable.shouldHave(text(userState + " " + userCity));
    }
}
