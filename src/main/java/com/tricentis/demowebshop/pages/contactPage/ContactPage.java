package com.tricentis.demowebshop.pages.contactPage;

import com.tricentis.demowebshop.common.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BasePage {

    private static Logger LOGGER = Logger.getLogger(ContactPage.class);

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Contact us')]")
    private WebElement contactLink;

    @CacheLookup
    @FindBy(id = "FullName")
    private WebElement FullName;

    //id="email"
    @CacheLookup
    @FindBy(id = "Email")
    private WebElement email;

    @CacheLookup
    @FindBy(id = "Enquiry")
    private WebElement Enquiry;

    @CacheLookup
    @FindBy(name = "send-email")
    private WebElement sendButton;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[3]/div")
    private WebElement successfulQuery;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Enter email')]")
    private WebElement Enteremail;

    @CacheLookup
    @FindBy(xpath = "//*[@id='rightPanel']/p[2]")
    private WebElement successMessage;



    //Constructor
    public ContactPage(WebDriver driver, int seconds) {
        super(driver, seconds);
        pageFactoryInitElement(driver, this);
    }

    public void fillContactFields() {
        try {
            typeOnTextField(FullName, "Juand");
            typeOnTextField(email, "juanddd@gmail.com");
            typeOnTextField(Enquiry, "Estoy teniendo problamas con la pagina 1");
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



    public void CompleteformConatctUs() {
        try {
            typeOnTextField(FullName, "Juand");
            typeOnTextField(Enquiry, "Estoy teniendo problamas con la pagina 1");
            clickOnElement(sendButton);
        } catch (Exception e) {
            LOGGER.error("Error al llenar los campos de contacto");
        }
    }
    public void EmailEmpty(){
        typeOnTextField(email, "");
    }
    public boolean MessageEnterEmail(){
        return isDisplayed(Enteremail);
    }


    public String getSuccessMessageText() {
        return getTextFromElement(successMessage);
    }
}
