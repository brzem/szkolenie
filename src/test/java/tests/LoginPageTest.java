package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest {
    WebDriver driver;
    ConfigReader config;
    LoginPage loginPage;

    @BeforeClass
    public void setup(){
        config = new ConfigReader();
        ChromeOptions options = new ChromeOptions();

        if(config.isNoDefaultBrowserCheck()){
            options.addArguments("--no-default-browser-check=new");
        }
        if(config.isNoFirstRun()){
            options.addArguments("--no-first-run=new");
        }
        if(config.isIncognito()){
            options.addArguments("--incognito");
        }
        options.addArguments("C://Users/Czester/AppData/Local/Google/Chrome/User Data/Default"
        );
        driver = new ChromeDriver(options);
        driver.get(config.getApplicationURL());
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void loginTest(){
        loginPage.setUserName(config.getUsername());
        loginPage.setPassword(config.getPassword());
        loginPage.clickLoginButton();
    }

    @Test
    public void invalidLoginTest(){
        loginPage.setUserName("qazwsx");
        loginPage.setPassword("qazqaz");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(), "Nieznana użytkownik. Proszę sprawdzić ponownie lub spróbować swój email.", "Otrzymano inny komunikat");

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
