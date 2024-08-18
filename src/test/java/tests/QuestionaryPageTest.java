package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoggerClass;
import pages.QuestionaryPage;

import java.time.Duration;


public class QuestionaryPageTest {

    WebDriver driver;
    ConfigReader config;
    QuestionaryPage questionaryPage;
    WebDriverWait wait;

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

        // t
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

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

    @Test
    public void QuestionaryAlertTest(){
        LoggerClass.info("QuestionaryAlertTest");
        questionaryPage.QuestionaryAlertTest();
    }

    @Test
    public void QuestionaryPromptAlertTest(){
        LoggerClass.info("QuestionaryPromptAlertTest");
        questionaryPage.QuestionaryPromptAlertTest();
    }

    @Test
    public void QuestionaryConfirmAcceptTest(){
        LoggerClass.info("QuestionaryConfirmAlertTest");
        questionaryPage.QuestionaryConfirmAcceptButtonTest();
    }

    @Test
    public void QuestionaryConfirmRejectTest(){
        LoggerClass.info("QuestionaryConfirmRejectTest");
        questionaryPage.QuestionaryConfirmDismissButtonTest();
    }

    @Test
    public void QuestionaryRightClickTest(){
        LoggerClass.info("QuestionaryRightClickTest");
        questionaryPage.QuestionaryRightClickTest();

        WebElement rightClickInfo = driver.findElement(By.xpath("//p[@id='rightClickInfo']"));
        String actuallText = rightClickInfo.getText();
        String expectedText = "Przycisk RIGHT został kliknięty";
        Assert.assertEquals(actuallText, expectedText, "Przycisk nie został kliknięty");
    }

    @Test
    public void QuestionaryProcessTest(){
        LoggerClass.info("QuestionaryProcessTest");
        questionaryPage.QuestionaryProcessClickTest();


        WebElement processInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='procesText']")));
        String actuallText = processInfo.getText();
        String expectedText = "Element Proces został wyświetlony";
        Assert.assertEquals(actuallText,expectedText, "Proces się nie wykonał");
    }

    @Test
    public void QuestionaryDoubleClickTest(){
        LoggerClass.info("QuestionaryDoubleClickTest");
        questionaryPage.QuestionaryDoubleClickTest();

    }

    @Test(description = "Test sprawdzajacy otwarcie i zamkniecie nowej karty w przegladarce")
    public void QuestionaryNewTabTest(){
        LoggerClass.info("QuestionaryNewTabTest");
        questionaryPage.QuestionaryNewTabTest();
    }

    @AfterClass
    public void teardown(){
        LoggerClass.info("Zamknięcie przeglądarki");
        if (driver != null){
            driver.quit();
        }
    }
}
