package com.visma.tests.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatepickerPage extends BaseWay2AutomationPage {

    private final String formatDateTab = "//a[@href='#example-1-tab-4']";

    //Alin : datepicker/defult4.html
    private final String formatDateFrame = "//iframe[@src='datepicker/defult4.html']";

    private final String dateField = "input#datepicker:first-child";

    private final String dateFormat = "//option[@value='yy-mm-dd']";

    //Alin - start region
    private final String datepicker = "datepicker";

    private final String todayDate = "[class~=ui-datepicker-today]";
    //Alin - end region


    public void goToFormatDateTab() {
        driver.findElement(By.xpath(formatDateTab)).click();
    }

    public void swithToTheIframeAndCompleteDateField() {
        Format formatter = new SimpleDateFormat("MM/dd/yy");
        String today = formatter.format(new Date());
        System.out.println(today);
        driver.switchTo().frame(driver.findElement(By.xpath(formatDateFrame)));
        //Alin - start region
        //driver.findElement(By.cssSelector(dateField)).sendKeys(today); // wrong !!
        driver.findElement(By.id(datepicker)).click();
        driver.findElement(By.cssSelector(todayDate)).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        Thread.sleep(10000);
//        driver.findElement(By.xpath(dateField)).click();
    }

    public void validateShownDate() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String shownDate = (String) jse.executeScript("return arguments[0].value", driver.findElement(By.id(datepicker)));
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format( Calendar.getInstance().getTime());

        assertEquals(currentDate,shownDate);
    }
    //Alin - end region

    public void selectDateFormat() {
        driver.findElement(By.xpath(dateFormat)).click();
    }


}
