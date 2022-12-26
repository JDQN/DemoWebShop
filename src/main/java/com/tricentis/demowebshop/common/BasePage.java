package com.tricentis.demowebshop.common;

import net.bytebuddy.implementation.bind.annotation.This;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


/*
 * @Author:<jdquimbayo72@gmail.com>
 * @version: 01
 */
public class BasePage {

    private static final Logger LOGGER = Logger.getLogger(BasePage.class);

    private static final String WEBDRIVER_NULL_MESSAGE = "\nWARNING!\n\rThe Webdriver is null, please check it.\n";
    protected WebDriver driver;


    /*
    * Creamos el construction
    * Sobre carga d econstructor para utilzar el pageFactory con tiempo inplicito
    * @param  driver para el navegador
    * @param tiempo de epera
    */
    public BasePage(WebDriver driver, int seconds){
        try {
            if (driver == null) LOGGER.warn(WEBDRIVER_NULL_MESSAGE);
            this.driver = driver;
            webDriverImplicitWait(driver, seconds);
        }catch (Exception e){
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Todo: Init POM with Page Factory
    protected void pageFactoryInitElement(WebDriver driver, Object page) {
        PageFactory.initElements(driver, page);
    }


    //Todo: Implicit wait. este metodo implementa un tiempo implicito d eespera
    private void webDriverImplicitWait(WebDriver driver, int seconds){
        try{
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        }catch(Exception e){
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Funcionalidades

    //Todo: 01 - Metodo para dar Click en el Elemento
    public void clickOnElement(WebElement element) {
        try{
            element.click();
        }catch (Exception e){
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Todo: 02 - Metodo para Escriba en el Campo de Texto (type on text field)
    protected void typeOnTextField(WebElement element, String value){
        try {
            element.clear();
            element.sendKeys(value);
        }catch(Exception e){
            LOGGER.warn(e.getMessage(), e);
        }
    }


    //Todo: 03 -  Metodo para hacer Scroll en el elemento (Scroll On Element)
    protected void scrollOn(WebElement element){
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);
        }catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }


    //Todo: 04 -  Metodo para que se muestre un elemeto (Is an Element Displayed)
    protected boolean isDisplayed(WebElement element){
        try {
            return element.isDisplayed();
        }catch(Exception e){
            LOGGER.warn(e.getMessage(), e);
            return false;
        }
    }


    //Todo: 05 - Metodo para Obtener texto del elemento (Get text from element)
    protected String getTextFromElement(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            return "";
        }
    }
}
