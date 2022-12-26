package com.tricentis.demowebshop.pages.loginPage;

import com.tricentis.demowebshop.common.BasePage;
import com.tricentis.demowebshop.model.UserRegistre;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(LoginPage.class);

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    private WebElement loginLink;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    private WebElement logOutLink;

    @CacheLookup
    @FindBy(id = "Email")
    private WebElement email;

    @CacheLookup
    @FindBy(id = "Password")
    private WebElement password;

    @CacheLookup
    @FindBy(xpath = "//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[5]/input[1]")
    private WebElement logIn;

    @CacheLookup
    @FindBy(xpath = "//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]")
    private WebElement logInEmpty;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Welcome to our store')]")
    private WebElement titleWelcomeToOurStore;

    public LoginPage(WebDriver driver, int seconds) {
        super(driver, seconds);
        pageFactoryInitElement(driver, this);
    }


    //TODO Implementando metodos esenarios 03 y 04

    //Step 1 - Metodo click en Register
    public void clickOnLogin(){
        clickOnElement(loginLink);
    }
    public void clickOnLogOut(){
        clickOnElement(logOutLink);
    }

    public void fillLoginFields(UserRegistre userRegistre) {
        try {
            typeOnTextField(email, userRegistre.getEmail());
            typeOnTextField(password, userRegistre.getPassword());
            clickOnElement(logIn);
        } catch (Exception e) {
            LOGGER.error("Error al llenar los campos email o password");
        }
    }
    public String titleWelcomeStore() {
        return getTextFromElement(titleWelcomeToOurStore);
    }

    public void fillLoginEmpty() {
        try {
            typeOnTextField(email,"");
            typeOnTextField(password,"");
            clickOnElement(logIn);
        } catch (Exception e) {
            LOGGER.error("Error al llenar los campos email o password");
        }
    }
    public String titleLoginWasUnsuccessful() {
        return getTextFromElement(logInEmpty);
    }
}
