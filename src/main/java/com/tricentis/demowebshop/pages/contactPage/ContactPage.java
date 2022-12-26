package com.tricentis.demowebshop.pages.contactPage;

import com.github.javafaker.Faker;
import com.tricentis.demowebshop.common.BasePage;
import com.tricentis.demowebshop.model.FormContact;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(ContactPage.class);

    Faker faker = new Faker();

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Contact us')]")
    private WebElement contactLink;

    @CacheLookup
    @FindBy(id = "FullName")
    private WebElement fullName;

    //id="email"
    @CacheLookup
    @FindBy(id = "Email")
    private WebElement email;

    @CacheLookup
    @FindBy(id = "Password")
    private WebElement password;

    @CacheLookup
    @FindBy(id = "Enquiry")
    private WebElement enquiry;

    @CacheLookup
    @FindBy(name = "send-email")
    private WebElement sendButton;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[3]/div")
    private WebElement successfulQuery;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Enter email')]")
    private WebElement enteremail;

    @CacheLookup
    @FindBy(xpath = "//*[@id='rightPanel']/p[2]")
    private WebElement successMessage;


    //Constructor
    public ContactPage(WebDriver driver, int seconds) {
        super(driver, seconds);
        pageFactoryInitElement(driver, this);
    }

    public void fillContactFields(FormContact formContact) {
        try {
            typeOnTextField(fullName, formContact.getFirstName());
            typeOnTextField(email, formContact.getEmail());
            typeOnTextField(enquiry, "Estoy teniendo problamas con la pagina 1");
            clickOnElement(sendButton);
        } catch (Exception e) {
            LOGGER.error("Error al llenar los campos de contacto");
        }
    }
    public void clickOnContactUs(){
        scrollOn(contactLink);
        clickOnElement(contactLink);
    }
    public boolean searchMessage(){
        return isDisplayed(successfulQuery);
    }

    public void completeformConatctUs(FormContact formContact) {
        try {
            typeOnTextField(fullName, formContact.getFirstName());
            typeOnTextField(enquiry, "Estoy teniendo problamas con la pagina 1");
            clickOnElement(sendButton);
        } catch (Exception e) {
            LOGGER.error("Error al llenar los campos de contacto");
        }
    }
    public void emailEmpty(){
        typeOnTextField(email, "");
    }
    public boolean messageEnterEmail(){
        return isDisplayed(enteremail);
    }


    public String getSuccessMessageText() {
        return getTextFromElement(successMessage);
    }

}
