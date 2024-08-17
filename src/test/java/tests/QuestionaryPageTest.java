package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoggerClass;
import pages.QuestionaryPage;


public class QuestionaryPageTest {

    WebDriver driver;
    ConfigReader config;
    QuestionaryPage questionaryPage;

    @BeforeClass
    public void setup(){
        config = new ConfigReader();
        ChromeOptions options = new ChromeOptions();
        if(config.isNoDefaultBrowserCheck()) {
            options.addArguments("--disable-search-engine-choice-screen");
        }

        if(config.isNoFirstRun()){
            options.addArguments("--no-first-run=new");
        }
        if(config.isIncognito()){
            options.addArguments("--incognito");
        }
        options.addArguments("user-data-dir=C:/Users/Czester/AppData/Local/Google/Chrome/User Data/Default"
        );
        driver = new ChromeDriver(options);
        driver.get(config.getQuestionaryURL());
        questionaryPage = PageFactory.initElements(driver, QuestionaryPage.class);
    }

    @Test
    public void QuestionaryFirstSetupTest(){
        LoggerClass.info("QuestionaryFirstSetupTest");
        questionaryPage.QuestionaryFirstSetupTest();
    }

    @Test
    public void QuestionaryDataPickerTest(){
        LoggerClass.info("QuestionaryDataPickerTest");
        questionaryPage.QuestionaryDataPickerTest();
    }

    @AfterClass
    public void teardown(){
        LoggerClass.info("Zamknięcie przeglądarki");
        if (driver != null){
            driver.quit();
        }
    }
}
