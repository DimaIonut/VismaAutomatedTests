package com.visma.tests.page;

import org.openqa.selenium.By;

public class AutomationPracticSitePage extends BaseWay2AutomationPage {

    private final String pageUrl = "http://way2automation.com/way2auto_jquery/automation-practice-site.html";

    private final String alertFigure = "//a[@href='alert.php']";

    private final String datePickerFigure = "//a[@href='datepicker.php']";

    public void moveFocusToTheCurrentTab() {
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(driver.getWindowHandle())) {
                driver.switchTo().window(tab);
            }
        }
    }

    public void open() {
        setupWebdriverChromeDriver();
        driver.get(pageUrl);
    }

    public void goToAlertPage() {
        driver.findElement(By.xpath(alertFigure)).click();
    }

    public void goToDatepickerPage() {
        driver.findElement(By.xpath(datePickerFigure)).click();
    }
}
