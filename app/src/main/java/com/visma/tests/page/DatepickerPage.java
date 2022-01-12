package com.visma.tests.page;

import org.openqa.selenium.By;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatepickerPage extends BaseWay2AutomationPage {

    private final String formatDateTab = "//a[@href='#example-1-tab-4']";

    private final String formatDateFrame = "//iframe[@src='datepicker/defult1.html']";

    private final String dateField = "input#datepicker:first-child";

    private final String dateFormat = "//option[@value='yy-mm-dd']";

    public void goToFormatDateTab() {
        driver.findElement(By.xpath(formatDateTab)).click();
    }

    public void swithToTheIframeAndCompleteDateField() {
        Format formatter = new SimpleDateFormat("MM/dd/yy");
        String today = formatter.format(new Date());
        System.out.println(today);
        driver.switchTo().frame(driver.findElement(By.xpath(formatDateFrame)));
        driver.findElement(By.cssSelector(dateField)).sendKeys(today);
    }

    public void selectDateFormat() {
        driver.findElement(By.xpath(dateFormat)).click();
    }

}
