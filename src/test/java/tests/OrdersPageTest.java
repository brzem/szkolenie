package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoggerClass;
import pages.OrdersPage;

public class OrdersPageTest {
    WebDriver driver;
    ConfigReader config;
    OrdersPage ordersPage;

    @BeforeClass
    public void setup(){
        config = new ConfigReader();
        ChromeOptions options = new ChromeOptions();

        if(config.isNoDefaultBrowserCheck()){
            options.addArguments("--disable-search-engine-choice-screen"); // --no-default-browser-check=new
        }
        if(config.isNoFirstRun()){
            options.addArguments("--no-first-run=new");
        }
        if(config.isIncognito()){
            options.addArguments("--incognito");
        }
        options.addArguments("user-data-dir=C:/Users/Czester/AppData/Local/Google/Chrome/User Data/Default");
        driver = new ChromeDriver(options);
        //Link do strony
        driver.get(config.getApplicationURL());
        ordersPage = PageFactory.initElements(driver, OrdersPage.class);
    }

    //Przypadek testowy do assercji na zakładce zamówienia na pierwszym nagłówku tabeli??

    @Test
    public void clickOrdersLinkAndAssercion() {
        LoggerClass.info("clickOrdersLinkAndAssercion");
        ordersPage.clickOrdersLinkAndAssercion(config.getUsername(), config.getPassword());
    }

//    @AfterClass
//    public void tearDown(){
//        LoggerClass.info("Zamknięcie przeglądarki");
//        if (driver != null){
//            driver.quit();
//        }
//    }

}
