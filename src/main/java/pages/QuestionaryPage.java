package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}
