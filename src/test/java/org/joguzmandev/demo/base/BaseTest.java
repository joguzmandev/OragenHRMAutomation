package org.joguzmandev.demo.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public abstract class BaseTest {

    public WebDriver webDriver;
    public WebDriverWait webDriverWait;

    @BeforeMethod
    public void setUp() {
        //Load ChromeDriver
        WebDriverManager.chromedriver().setup();
        //Instance new ChromeDrive
        webDriver = new ChromeDriver();
        webDriver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @AfterMethod
    public void disposeWebDriver() {
        webDriver.close();
    }
}
