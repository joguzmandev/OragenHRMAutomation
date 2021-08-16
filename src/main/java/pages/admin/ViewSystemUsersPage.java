package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewSystemUsersPage {

    private WebDriverWait webDriverWait;
    private WebDriver webDriver;

    @FindBy(css = "a#menu_admin_Organization")
    private WebElement organizationMenu;
    @FindBy(css = "a#menu_admin_viewCompanyStructure")
    private WebElement structureSubMenu;

    public ViewSystemUsersPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 5);
    }

    public ViewCompanyStructurePage clickToStructureSubMenuLink()  {
        Actions builder = new Actions(webDriver);
        Action action = builder.moveToElement(organizationMenu).
                moveToElement(structureSubMenu)
                .click()
                .build();
        action.perform();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("btnEdit")
                )
        );
        return new ViewCompanyStructurePage(webDriver);
    }

}
