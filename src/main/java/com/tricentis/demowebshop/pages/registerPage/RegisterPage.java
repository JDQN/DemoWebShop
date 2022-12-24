package com.tricentis.demowebshop.pages.registerPage;

import com.tricentis.demowebshop.common.BasePage;
import com.tricentis.demowebshop.pages.contactPage.ContactPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    private static Logger LOGGER = Logger.getLogger(RegisterPage.class);

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
    private WebElement registerLink;

    @CacheLookup
    @FindBy(id = "FirstName")
    private WebElement firstName;

    //id="email"
    @CacheLookup
    @FindBy(id = "LastName")
    private WebElement lastName;

    @CacheLookup
    @FindBy(id = "Email")
    private WebElement email;

    @CacheLookup
    @FindBy(id = "Password")
    private WebElement password;

    @CacheLookup
    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPassword;

    @CacheLookup
    @FindBy(xpath = "//input[@id='register-button']")
    private WebElement registerLinkBtn;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
    private WebElement successRegister;

    @CacheLookup
    @FindBy(xpath = "//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[2]/input[1]")
    private WebElement continueLinkBtn;



    //Constructor de la clase
    public RegisterPage(WebDriver driver, int seconds) {
        super(driver, seconds);
        pageFactoryInitElement(driver, this);
    }

    //Todo Scenario 05
    public void clickOnRegister(){
        clickOnElement(registerLink);
    }
    public void completeformRegister() {
        try {
            typeOnTextField(firstName, "Juan1");
            typeOnTextField(lastName, "Perez");
            typeOnTextField(email, "argentina3@gmail.com");
            typeOnTextField(password, "123456");
            typeOnTextField(confirmPassword, "123456");
            clickOnElement(registerLinkBtn);
        } catch (Exception e) {
            LOGGER.error("Error al llenar los campos de contacto");
        }
    }
    public boolean searchMessageRegister(){
        return isDisplayed(successRegister);
    }
    public void clickOnContinueBtn(){
        clickOnElement(continueLinkBtn);
    }


    //Todo Scenario 06
    public void incompleteFormRegister() {
        try {
            typeOnTextField(firstName, "");
            typeOnTextField(lastName, "");
            typeOnTextField(email, "");
            typeOnTextField(password, "");
            typeOnTextField(confirmPassword, "");
            clickOnElement(registerLinkBtn);
        } catch (Exception e) {
            LOGGER.error("Error al llenar los campos de contacto");
        }
    }


}
