package pages.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.dashboard.DashboardPage;

public class LoginPage {

    private WebDriverWait webDriverWait;
    private WebDriver webDriver;

    @FindBy(id = "txtUsername")
    private WebElement userNameInputField;

    @FindBy(id = "txtPassword")
    private WebElement passwordInputField;

    @FindBy(id = "btnLogin")
    private WebElement loginButton;

    public LoginPage(WebDriver webDriver){
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

    public String clickLoginButtonInvalidCredentials(){
        loginButton.click();
        By idSelectorSpan = By.id("spanMessage");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                idSelectorSpan
        ));
        return this.webDriver.findElement(idSelectorSpan).getText();
    }

    public DashboardPage clickLoginButtonValidCredentials(){
        loginButton.click();
        return new DashboardPage(webDriver);

    }
}
