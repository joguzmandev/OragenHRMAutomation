package org.joguzmandev.demo.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDropDown {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        webDriver = new ChromeDriver();
        webDriver.get("http://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void test_select_element_dropdown(){
        WebElement dropDown = webDriver.findElement(By.id("dropdown"));
      //  Select
    }
}
