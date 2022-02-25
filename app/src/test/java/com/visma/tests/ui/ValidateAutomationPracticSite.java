package com.visma.tests.ui;

import com.visma.tests.page.AlertPage;
import com.visma.tests.page.AutomationPracticSitePage;
import com.visma.tests.page.DatepickerPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateAutomationPracticSite {

    private final AutomationPracticSitePage automationPracticSitePage = new AutomationPracticSitePage();

    private final AlertPage alertPage = new AlertPage();

    private final DatepickerPage datepickerPage = new DatepickerPage();

    private final String myName = "Dima Ionut";

    @Test
    @DisplayName("Validate the shown message contains my name from the previous step")
    public void validateTheShownMessage() {
        automationPracticSitePage.open();
        automationPracticSitePage.goToAlertPage();
        automationPracticSitePage.moveFocusToTheCurrentTab();
        alertPage.goToInputAlertTab();
        alertPage.swithToTheIframeAndClickOnTheInputBoxButton();
        alertPage.insertNameOnThePopUp(myName);

        Assertions.assertTrue(alertPage.getShownMessage().contains(myName));

        automationPracticSitePage.close();
    }

    @Test
    public void validateTheShownDateAgainstTheCurrentDate() {
        automationPracticSitePage.open();
        automationPracticSitePage.goToDatepickerPage();
        automationPracticSitePage.moveFocusToTheCurrentTab();
        datepickerPage.goToFormatDateTab();
        datepickerPage.swithToTheIframeAndCompleteDateField();
        datepickerPage.selectDateFormat();

        automationPracticSitePage.close();
    }

    @Test
    public void testHackerearth() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://interview.navx.com/");
    }
}
