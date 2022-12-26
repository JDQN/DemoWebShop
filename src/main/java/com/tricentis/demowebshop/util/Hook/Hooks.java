package com.tricentis.demowebshop.util.Hook;

import com.tricentis.demowebshop.common.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks  extends BasePage {

    public Hooks(WebDriver driver, int seconds) {
        super(driver, seconds);
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            scenario.log("ESTO FALLO MAN");
            final  byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach((screenshot),"image/png","la propia imagen perro");
        }
    }
}
