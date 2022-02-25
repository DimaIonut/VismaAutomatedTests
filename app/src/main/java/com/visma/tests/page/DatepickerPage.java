package com.visma.tests.page;

import org.openqa.selenium.By;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DatepickerPage extends BaseWay2AutomationPage {

    private final String formatDateTab = "//a[@href='#example-1-tab-4']";

    private final String formatDateFrame = "//iframe[@src='datepicker/defult1.html']";

    private final String dateField = "//input[@id='datepicker']";

    private final String dateFormat = "//option[@value='yy-mm-dd']";

    private final String formatOptions = "//select[@id='format']";

    public void goToFormatDateTab() {
        driver.findElement(By.xpath(formatDateTab)).click();
    }

    public void swithToTheIframeAndCompleteDateField() {
        Format formatter = new SimpleDateFormat("MM/dd/yy");
        String today = formatter.format(new Date());
        System.out.println(today);
        driver.switchTo().frame(driver.findElement(By.xpath(formatDateFrame)));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        Thread.sleep(10000);
//        driver.findElement(By.xpath(dateField)).click();
    }

    public void selectDateFormat() {
        driver.findElement(By.xpath(formatOptions)).click();
        driver.findElement(By.xpath(dateFormat)).click();
    }

}
