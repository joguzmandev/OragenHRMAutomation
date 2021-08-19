package org.joguzmandev.demo.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDropDown {
    private WebDriver webDriver;
    
    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        webDriver = new ChromeDriver();
        webDriver.get("http://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void test_select_element_dropdown(){
        WebElement dropDownElement = webDriver.findElement(By.id("dropdown"));

        Select dropDown = new Select(dropDownElement);

        dropDown.selectByIndex(2);

    }
}
