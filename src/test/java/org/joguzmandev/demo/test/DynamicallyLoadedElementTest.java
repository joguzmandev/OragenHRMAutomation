package org.joguzmandev.demo.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.others.DynamicallyLoadedElementPage;

public class DynamicallyLoadedElementTest {

    private WebDriver webDriver;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
    }

    @Test(description = "Get dynamically page element")
    public void test_get_dynamically_page_element(){
        DynamicallyLoadedElementPage loadedElementPage = new DynamicallyLoadedElementPage(webDriver);

        loadedElementPage.clickStartButton();

        Assert.assertEquals("Hello World!",loadedElementPage.getOutputResult(),"Dynamically Element could not loaded correctly");
    }

    @AfterTest
    public void tearDown(){
        webDriver.close();
    }
}
