package pages.bancopiano;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
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

    @FindBy(css = "a#lnkEnviar")
    private WebElement requestTurnButton;

    private By modalFrameTurnId = By.cssSelector("iframe#turnos-frame");


    //Fields of window modal
    @FindBy(xpath = "//input[contains(@id,\"txtnombre\")]")
    private WebElement txtNombreInput;

    @FindBy(xpath = "//input[contains(@id,\"documento\")]")
    private WebElement txtDcomentoInput;

    @FindBy(xpath = "//input[contains(@id,\"cboSucursales\")]")
    private Select cbSucursalesDropDown;

    @FindBy(xpath = "//input[contains(@id,\"cboSector\")]")
    private Select cbSectorDropDown;

    @FindBy(xpath = "//input[contains(@id,\"CboHorarios\")]")
    private Select cbHorarioDropDown;

    @FindBy(xpath = "//input[contains(@id,\"cphPageContent_email\")]")
    private WebElement txtEmailInput;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 10);
        PageFactory.initElements(webDriver, this);
    }

    public void clickToCloseModalButton() {
        modalWindowCloseButton.click();
    }

    public void clickToWebTurnButton() {
        webTurnButton.click();
    }

    public void clickToNotButtonRetiredOrPensionerWindowModal() {
        webDriverWait
                .until(ExpectedConditions.visibilityOf(webDriver.findElement(By.cssSelector("div.message-td-form"))));
        popBtnNoButton.click();
    }

    public void typeFullname(String fullname){
        txtNombreInput.sendKeys(fullname);
    }

    public void typeDocument(String document){
        txtDcomentoInput.sendKeys(document);
    }

    public void setSucursal(int sucursalId){
        cbSucursalesDropDown.selectByIndex(sucursalId);
    }

    public void setSector(int sectorId){
        cbSectorDropDown.selectByIndex(sectorId);
    }

    public void setHorario(int horarioId){
        cbHorarioDropDown.selectByIndex(horarioId);
    }

    public void typeEmail(String email){
       txtEmailInput.sendKeys(email);
    }


    public void clickToDoValidationWithAllFieldsEmpty(){
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(modalFrameTurnId));
        webDriver.switchTo().frame(webDriver.findElement(modalFrameTurnId));

        //Check all fields here
        Long init = System.currentTimeMillis();
        requestTurnButton.click();
        Long end = System.currentTimeMillis();
        System.out.println(init-end);
        System.out.println("All gonna be fine " + txtNombreInput.getAttribute("style"));
        webDriver.switchTo().defaultContent();
    }


    public void clickToRequestTurnButtonModal() {

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(modalFrameTurnId));

        webDriver.switchTo().frame(webDriver.findElement(modalFrameTurnId));

        requestTurnButton.click();

        webDriver.switchTo().defaultContent();
    }

    public String displayErrorMessageRequiredInputs() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(modalFrameTurnId));
        webDriver.switchTo().frame(webDriver.findElement(modalFrameTurnId));
        By txtNameInputModal = By.xpath("//input[contains(@id,\"txtnombre\") and contains(@style,\"border\")]");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(txtNameInputModal));

        return "Name is required";
    }
}
