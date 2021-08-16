package pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewCompanyStructurePage {
    private WebDriverWait webDriverWait;
    private WebDriver webDriver;
    private AddUnitStructureModal structureModal;

    @FindBy(id="btnEdit")
    private WebElement editButton;

    @FindBy(id = "treeLink_addChild_1")
    private WebElement rootTreeAddChildLink;

    public ViewCompanyStructurePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver,this);
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver,5);
    }

    public void clickEditButton(){
        editButton.click();
        webDriverWait.until(
              item ->item.findElement(By.id("treeLink_addChild_1"))
        );
    }

    public void clickRootTreeLink(){
        rootTreeAddChildLink.click();
    }

    public String addNewUnitStructureWithAtLeastEmptyFields(String unitId,String unitName,String unitDescription){
        this.structureModal = new AddUnitStructureModal(webDriver);
        this.structureModal.typeUnitId(unitId);
        this.structureModal.typeName(unitName);
        this.structureModal.typeDescription(unitDescription);
        return this.structureModal.clickSaveWithAtLeastEmptyFields();
    }

    public String addNewUnitStructureWithRequiredFieldNotEmpty(String unitId,String unitName,String unitDescription){
        this.structureModal = new AddUnitStructureModal(webDriver);
        this.structureModal.typeUnitId(unitId);
        this.structureModal.typeName(unitName);
        this.structureModal.typeDescription(unitDescription);

        this.structureModal.clickSaveWithRequiredFieldNotEmpty();

        By divMessageBar = By.cssSelector("#messageDiv>#divMessageBar");

        return webDriverWait.until(
                ExpectedConditions.visibilityOfElementLocated(divMessageBar)
        ).getText();
    }

    public void addNewUnitStructureWithAllFieldsFilledInAndCancelForm(String unitId,String unitName,String unitDescription){
        this.structureModal = new AddUnitStructureModal(webDriver);
        this.structureModal.typeUnitId(unitId);
        this.structureModal.typeName(unitName);
        this.structureModal.typeDescription(unitDescription);

        this.structureModal.clickCancelButton();

        By divMessageBar = By.cssSelector("#messageDiv>#divMessageBar");
    }
}
