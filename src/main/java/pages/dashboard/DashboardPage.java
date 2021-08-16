package pages.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import pages.admin.ViewSystemUsersPage;

public class DashboardPage {
    private WebDriverWait webDriverWait;
    private WebDriver webDriver;

    @FindBy(css = "a#menu_admin_viewAdminModule")
    private WebElement adminMenuLink;

    public DashboardPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver,this);
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver,5);
    }

    public String isUserLoggedOnDashboard(){
        By cssSelectorAdminName = By.cssSelector("a#menu_admin_viewAdminModule>b");
       return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
               cssSelectorAdminName
       )).getText();
    }

    public ViewSystemUsersPage clickToGoAdminMenu(){
        adminMenuLink.click();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("menu_admin_Organization")
                )
        );

        return new ViewSystemUsersPage(webDriver);
    }
}
