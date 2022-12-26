package stepDefinitions.setup;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.tricentis.demowebshop.util.Log4jValues.LOG4J2_PROPERTIES_FILE_PATH;
import static com.google.common.base.StandardSystemProperty.USER_DIR;


public class BaseTestPage {

    //Con el atributo private static final String  WEBDRIVER_CHROME_DRIVER utilizamos el driver de google
    private static final String  WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";

    //Con el atributo private static final String WEBDRIVER_CHROME_DRIVER_PATH hacemos referencia a la ruta donde esta almacenado el driver
    private static final String  WEBDRIVER_CHROME_DRIVER_PATH = "src/test/resources/webDriver/windows/chromedriver.exe";

    //Colocamos la URL de la pagian a probar
    private static final String DEMO_QA_URL = "https://demowebshop.tricentis.com/";

    //Creamos una variable protegida llamada WebDriver la cual vamos a utilizar en el resto del proyecto
    protected WebDriver driver;

    //Metodo para inicializar las propiedades del driver
    protected void setUpWebDriver() {
        System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_PATH);
    }

    //Metodo que permite optener la pagina, abrirla mazimizarla
    protected void generalSetup(){
        driver = new ChromeDriver();
        driver.get(DEMO_QA_URL);
        driver.manage().window().maximize();
    }

    //Permite inicializar las propiedades del log4j2
    protected void setUpLog4j2(){
        PropertyConfigurator.configure(USER_DIR.value() + LOG4J2_PROPERTIES_FILE_PATH.getValue());
    }


    //Metodo para cerrar el driver
    protected void quiteDriver() {
        driver.quit();
    }

}
