package pages.others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicallyLoadedElementPage {

    @FindBy(xpath = "//div[@id=\"start\"]/button")
    private WebElement startButton;

    private WebDriver webDriver;

    public DynamicallyLoadedElementPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public void clickStartButton(){
        startButton.click();
    }

    public String getOutputResult(){
        By h4OutPutField = By.xpath("//div[@id=\"finish\"]/h4");
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,10);
        webDriverWait.until(
                ExpectedConditions.visibilityOfElementLocated(
                      h4OutPutField
                )
        );
        return webDriver.findElement(h4OutPutField).getText();
    }

}
