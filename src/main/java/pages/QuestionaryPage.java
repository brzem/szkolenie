package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;
import java.util.logging.Logger;

public class QuestionaryPage {
    WebDriver driver;
    Actions actions;

    @FindBy(xpath = "//input[@id='Imię']")
    WebElement questionaryName;

    @FindBy(xpath = "//input[@id='Nazwisk']")
    WebElement questionarySurname;

    @FindBy(xpath = "//input[@id='Płeć' and @value='Mężczyzna']")
    WebElement questionaryMale;

    @FindBy(xpath = "//input[@id='Wiek' and @value='20-29']")
    WebElement questionaryAge;

    @FindBy(xpath = "//input[@id='Płeć' and @value='Kobieta']")
    WebElement questionaryFemale;

    @FindBy(xpath = "//input[@name='Produkt' and @value='Koszulka meczowa']")
    WebElement questionaryProductTshirt;

    @FindBy(xpath = "//input[@name='Produkt' and @value='Piłka nożna']")
    WebElement questionaryProductFootBall;

    @FindBy(xpath = "//input[@name='Produkt' and @value='Buty sportowe']")
    WebElement questionaryProductShoes;

    @FindBy(xpath = "//input[@name='Produkt' and @value='Torba sportowa']")
    WebElement questionaryProductBackPack;

    @FindBy(xpath = "//input[@name='Muzyka' and @value='Inna']")
    WebElement questionaryAnother;

    @FindBy(xpath = "//input[@name='Produkt' and @type='text']")
    WebElement questionaryAnotherTextArea;

    @FindBy(xpath = "//input[@class='form-control white']")
    WebElement questionaryDataPicker;

    @FindBy(xpath = "//input[@type='button' and @value='Alert']")
    WebElement questionaryAlertButton;

    @FindBy(xpath = "//input[@type='button' and @value='Prompt Alert']")
    WebElement questionaryPromptAlertButton;

    @FindBy(xpath = "//input[@type='button' and @value='Confirm Alert']")
    WebElement questionaryConfirmAlertButton;

    @FindBy(xpath = "//input[@type='button' and @value='Kliknij RIGHT']")
    WebElement questionaryRightClickButton;

    @FindBy(xpath = "//input[@type='button' and @value='Dwuklik pokaż komunikat']")
    WebElement questionaryDoubleClickButton;

    @FindBy(xpath= "//input[@type='button' and @value='PROCES']")
    WebElement questionaryProcessClickButton;

    @FindBy(xpath= "//input[@type='button' and @value='Otwórz nowe okno']")
    WebElement questionaryNewTab;

    @FindBy(xpath= "//input[@id='imie_nazwisko']")
    WebElement questionaryNameSurname;

    @FindBy(xpath= "//input[@type='button' and @value='Zamknij okno przeglądarki']")
    WebElement questionaryCloseOpenedTab;

    //Konstruktor
    public  QuestionaryPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void QuestionaryFirstSetupTest() {
        LoggerClass.info("First Setup Test - textboxes / radiobuttons / checkbox");
        questionaryName.sendKeys("Bartosz");

        LoggerClass.info("First Setup Test - input surname");
        questionarySurname.sendKeys("Rzemyk");

        LoggerClass.info("First Setup Test - input male");
        questionaryMale.click();

        LoggerClass.info("First Setup Test - radiobutton Age");
        questionaryAge.click();

        LoggerClass.info("First Setup Test - checkbox Product");
        questionaryProductTshirt.click();
        questionaryProductFootBall.click();
        questionaryProductShoes.click();
        questionaryProductBackPack.click();
        questionaryAnotherTextArea.click();

    }

    public void QuestionaryDataPickerTest(){
        LoggerClass.info("QuestionaryDataPicker");
        questionaryDataPicker.clear();
        questionaryDataPicker.sendKeys("31-07-2024");
        actions.sendKeys(Keys.ESCAPE).perform();

    }

    public void QuestionaryAlertTest(){
        LoggerClass.info("QuestionaryAlert ");
        questionaryAlertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    public void QuestionaryPromptAlertTest(){
        LoggerClass.info("QuestionaryPromptAlert");
        questionaryPromptAlertButton.click();

        //Przygotowanie tekstu dla prompt alert
        Alert promptAlert = driver.switchTo().alert();
        String textToPromptAlert = "Testowy tekst";
        promptAlert.sendKeys(textToPromptAlert);
        promptAlert.accept();
    }

    public void QuestionaryConfirmAcceptButtonTest() {
        LoggerClass.info("QuestionaryConfirmAcceptButtonTest");
        questionaryConfirmAlertButton.click();
        Alert acceptAlert = driver.switchTo().alert();
        acceptAlert.accept();
    }

    public void QuestionaryConfirmDismissButtonTest() {
        LoggerClass.info("QuestionaryConfirmDismissButton ");
        questionaryConfirmAlertButton.click();
        Alert acceptAlert = driver.switchTo().alert();
        acceptAlert.dismiss();
    }


    public void QuestionaryRightClickTest(){
        LoggerClass.info("QuestionaryRightClick");
        actions.contextClick(questionaryRightClickButton).perform();
        assert(driver.findElement(By.xpath("//p[@id='rightClickInfo']"))).isDisplayed();


    }

    public void QuestionaryProcessClickTest(){
        LoggerClass.info("QuestionaryProcessClick");
        questionaryProcessClickButton.click();

    }

    public void QuestionaryDoubleClickTest(){
        LoggerClass.info("QuestionaryDoubleClick");
        actions.doubleClick(questionaryDoubleClickButton).perform();
    }

    public void QuestionaryNewTabTest(){
        LoggerClass.info("QuestionaryNewTab");
        questionaryNewTab.click();

        // Pobranie informacji o pierwotnej zakładce
        String originalTabName = driver.getWindowHandle();


        //Oczekiwanie na otwarcie się nowej zakładki
        Set<String> allWindows = driver.getWindowHandles();
        while(allWindows.size() == 1) {
            allWindows = driver.getWindowHandles();
        }

        // Przełączanie na drugą zakładkę
        for(String windowHandle : allWindows) {
            if (!windowHandle.equals(originalTabName)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Sprawdzenie czy zmieniono zakładkę

        // Obsługa nowej zakładki
        questionaryNameSurname.sendKeys("Imie i nazwisko");
        questionaryCloseOpenedTab.click();

        // Powrót do pierwszej zakładki
        driver.switchTo().window(originalTabName);
    }
}
