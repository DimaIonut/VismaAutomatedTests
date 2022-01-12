package com.visma.tests.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseWay2AutomationPage {

    public static WebDriver driver;

    public void setupWebdriverChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
