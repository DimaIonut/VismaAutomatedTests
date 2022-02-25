package com.visma.tests.page;

import org.openqa.selenium.By;

public class AlertPage extends BaseWay2AutomationPage {

    private final String inputAlertTab = "//a[@href='#example-1-tab-2']";

    private final String demoAlertFrame = "//iframe[@src='alert/input-alert.html']";

    private final String inputBoxButton = "//button[@onclick='myFunction()']";

    private final String shownMessage = "//p[@id='demo']";

    public void goToInputAlertTab() {
        driver.findElement(By.xpath(inputAlertTab)).click();

        driver.findElement(By.cssSelector("[id='email']")).sendKeys("");
        driver.findElement(By.cssSelector(("[id='getEmail']"))).click();
    }

    public void swithToTheIframeAndClickOnTheInputBoxButton() {
        driver.switchTo().frame(driver.findElement(By.xpath(demoAlertFrame)));
        driver.findElement(By.xpath(inputBoxButton)).click();
    }

    public void insertNameOnThePopUp(String name) {
        driver.switchTo().alert().sendKeys(name);
        driver.switchTo().alert().accept();
    }

    public String getShownMessage() {
        return driver.findElement(By.xpath(shownMessage)).getText();
    }
}
