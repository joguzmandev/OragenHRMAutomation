package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddUnitStructureModal {

    private WebDriverWait webDriverWait;

    @FindBy(id = "txtUnit_Id")
    private WebElement unitIdField;

    @FindBy(id = "txtName")
    private WebElement unitNameField;

    @FindBy(id = "txtDescription")
    private WebElement unitDescriptionField;

    @FindBy(id = "btnSave")
    private WebElement saveButton;

    @FindBy(id = "btnCancel")
    private WebElement cancelButton;

    public AddUnitStructureModal(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriverWait = new WebDriverWait(webDriver, 5);
    }

    public void typeUnitId(String unitId) {
        this.unitIdField.sendKeys(unitId);
    }

    public void typeName(String name) {
        this.unitNameField.clear();
        this.unitNameField.sendKeys(name);
    }

    public void typeDescription(String description) {
        this.unitDescriptionField.sendKeys(description);
    }

    public String clickSaveWithAtLeastEmptyFields(){
        By errorNameMessage = By.cssSelector("span[for=\"txtName\"]");
        this.saveButton.click();
        return webDriverWait.until(
                item-> item.findElement(errorNameMessage)
        ).getText();
    }

    public void clickSaveWithRequiredFieldNotEmpty(){
        this.saveButton.click();
    }

    public void clickCancelButton(){
        this.cancelButton.click();
    }
}
