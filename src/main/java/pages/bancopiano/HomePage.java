package pages.bancopiano;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @FindBy(xpath = "//button[@title=\"Close\"]")
    private WebElement modalWindowCloseButton;

    @FindBy(xpath = "//a[contains(text(),\"Turnos Web\")]")
    private WebElement webTurnButton;

    @FindBy(css = "a#pop-btn-no")
    private WebElement popBtnNoButton;

    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver,10);
        PageFactory.initElements(webDriver,this);
    }

    public void clickToCloseModalButton(){
        modalWindowCloseButton.click();
    }

    public void clickToWebTurnButton(){
        webTurnButton.click();
    }

    public void clickToNotButtonRetiredOrPensionerWindowModal(){
        webDriverWait.until(
                ExpectedConditions.visibilityOf(webDriver.findElement(By.cssSelector("div.message-td-form")))
        );
        popBtnNoButton.click();
    }
}
