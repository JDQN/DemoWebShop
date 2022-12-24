package com.tricentis.demowebshop.pages.loginPage;

import com.tricentis.demowebshop.common.BasePage;
import com.tricentis.demowebshop.model.UserRegistre;
import com.tricentis.demowebshop.pages.contactPage.ContactPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private static Logger LOGGER = Logger.getLogger(LoginPage.class);

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    private WebElement LoginLink;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    private WebElement LogOutLink;

    @CacheLookup
    @FindBy(id = "Email")
    private WebElement Email;

    @CacheLookup
    @FindBy(id = "Password")
    private WebElement Password;

    @CacheLookup
    @FindBy(xpath = "//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[5]/input[1]")
    private WebElement LogIn;

    @CacheLookup
    @FindBy(xpath = "//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]")
    private WebElement LogInEmpty;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Welcome to our store')]")
    private WebElement titleWelcomeToOurStore;

    public LoginPage(WebDriver driver, int seconds) {
        super(driver, seconds);
        pageFactoryInitElement(driver, this);
    }


    //Todo: Implementando metodos esenarios 03 y 04

    //Step 1 - Metodo click en Register
    public void clickOnLogin(){
        clickOnElement(LoginLink);
    }
    public void clickOnLogOut(){
        clickOnElement(LogOutLink);
    }

    public void fillLoginFields(UserRegistre userRegistre) {
        try {
            typeOnTextField(Email, userRegistre.getEmail());
            typeOnTextField(Password, userRegistre.getPassword());
            clickOnElement(LogIn);
        } catch (Exception e) {
            LOGGER.error("Error al llenar los campos email o password");
        }
    }
    public String titleWelcomeStore() {
        return getTextFromElement(titleWelcomeToOurStore);
    }

    public void fillLoginEmpty() {
        try {
            typeOnTextField(Email,"");
            typeOnTextField(Password,"");
            clickOnElement(LogIn);
        } catch (Exception e) {
            LOGGER.error("Error al llenar los campos email o password");
        }
    }
    public String titleLoginWasUnsuccessful() {
        return getTextFromElement(LogInEmpty);
    }
}
