package com.kuryaevao.pages;

import com.codeborne.selenide.SelenideElement;
import com.kuryaevao.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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

    public void openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public void typeFirstName(String value) {
        firstNameInput.setValue(value);
    }

    public void typeLastName(String value) {
        lastNameInput.setValue(value);
    }

    public void typeEmail(String value) {
        emailInput.setValue(value);
    }

    public void typePhone(String value) {
        phoneInput.setValue(value);
    }

    public void typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
    }

    public void selectGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
    }

    public void selectSubject(String value) {
        subjectInput.setValue(value).pressEnter();
    }

    public void selectHobbies(String value) {
        hobbieWrapper.$(byText(value)).click();
        ;
    }

    public void selectState(String value) {
        stateInput.scrollTo().click();
        stateCityWrapper.$(byText(value)).click();
    }

    public void selectCity(String value) {
        cityInput.click();
        stateCityWrapper.$(byText(value)).click();
    }

    public void submitForm() {
        submitInput.scrollTo().pressEnter();
    }

    public SelenideElement createdTable = $(byClassName("table-responsive"));
}
