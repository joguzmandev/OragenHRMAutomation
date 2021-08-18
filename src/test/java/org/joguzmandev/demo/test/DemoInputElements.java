package org.joguzmandev.demo.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DemoInputElements {
    private WebDriver webDriver;

    @BeforeTest
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://formy-project.herokuapp.com/form");
    }

    @Test
    public void test_count_inputs(){
        List<WebElement> elements = webDriver.findElements(By.tagName("input"));
        System.out.printf("Inputs element count: %s%n", elements.size());
        Assert.assertEquals(10, elements.size(), "all inputs not found it");
    }

    @AfterTest
    public void dispose(){
        webDriver.close();
    }
}
