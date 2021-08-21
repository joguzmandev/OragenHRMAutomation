package org.joguzmandev.demo.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.bancopiano.HomePage;

public class WebTurnTest {

    private WebDriver webDriver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.bancopiano.com.ar/");
    }

    @Test
    public void test_request_web_turn_all_empty_fields() {
        HomePage homePage = new HomePage(webDriver);
        //Step 1 : Close Modal
        homePage.clickToCloseModalButton();
        //Step 2 : Open Web Turn
        homePage.clickToWebTurnButton();
        //Step 3 : Click to not Retired or Pensioner Modal button
        homePage.clickToNotButtonRetiredOrPensionerWindowModal();
        //Step 4 : Click to Request turn button
        homePage.clickToDoValidationWithAllFieldsEmpty();

    }

    @AfterTest
    public void tearDown() {

    }
}
