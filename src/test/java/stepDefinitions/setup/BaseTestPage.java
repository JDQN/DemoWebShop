package stepDefinitions.setup;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.tricentis.demowebshop.util.Log4jValues.LOG4J2_PROPERTIES_FILE_PATH;
import static com.google.common.base.StandardSystemProperty.USER_DIR;


public class BaseTestPage {

    private static final String  WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";

    private static final String  WEBDRIVER_CHROME_DRIVER_PATH = "src/test/resources/webDriver/windows/chromedriver.exe";

    private static final String DEMO_QA_URL = "https://demowebshop.tricentis.com/";

    protected WebDriver driver;

    protected void setUpWebDriver() {
        System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_PATH);
    }

    protected void generalSetup(){
        driver = new ChromeDriver();
        driver.get(DEMO_QA_URL);
        driver.manage().window().maximize();
    }

    protected void setUpLog4j2(){
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J2_PROPERTIES_FILE_PATH.getValue());
    }

    protected void quiteDriver() {
        driver.quit();
    }

}
