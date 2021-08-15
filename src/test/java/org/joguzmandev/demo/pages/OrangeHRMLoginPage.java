package org.joguzmandev.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMLoginPage {

    private WebDriverWait webDriverWait;
    private WebDriver webDriver;

    @FindBy(id = "txtUsername")
    private WebElement userNameInputField;

    @FindBy(id = "txtPassword")
    private WebElement passwordInputField;

    @FindBy(id = "btnLogin")
    private WebElement loginButton;

    public OrangeHRMLoginPage(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver,5);
    }

    public void typeUserName(String userName){
        userNameInputField.sendKeys(userName);
    }

    public void typePassword(String password){
        passwordInputField.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public String messageWithUsernameOrPasswordEmpty(){
        By idSelector = By.id("spanMessage");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                idSelector
        ));
        return this.webDriver.findElement(idSelector).getText();
    }

    public String messageWhenLoginIsCorrect(){
        By cssSelector = By.cssSelector("a#menu_admin_viewAdminModule>b");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                cssSelector
        ));
        return this.webDriver.findElement(cssSelector).getText();
    }
}
