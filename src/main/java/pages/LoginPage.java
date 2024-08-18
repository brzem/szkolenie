package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;

    //Elementy strony
    @FindBy(xpath = "//input[@id='username']")
    WebElement userNameField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;


    @FindBy(xpath = "//button[@type='submit' and @value='Zaloguj się']")
    WebElement loginButton;

    @FindBy(xpath ="//li[text()=' Nieznana użytkownik. Proszę sprawdzić ponownie lub spróbować swój email.']" )
    WebElement errorMessage;

    @FindBy(xpath = "//a[text()='Wyloguj']")
    WebElement logoutButton;


    //Konstruktor klasy LoginPage
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Metody do interakcji na stronie
    public void loginTest(String userName, String password) {
        LoggerClass.info("Podanie nazwy usera do pola input");
        userNameField.sendKeys(userName);

        LoggerClass.info("Podanie nazwy password do pola input");
        passwordField.sendKeys(password);

        LoggerClass.info("Wciśnięcie przycisku Zaloguj");
        loginButton.click();

        LoggerClass.info("Kliknięcie przycisku wyloguj");
                logoutButton.click();
    }

    public void logoutTest(){
        LoggerClass.info("Logout  correctly");
        logoutButton.click();
    }


    public void invalidLoginTest(String userName, String password) {
        LoggerClass.info("Podanie nazwy usera do pola input");
        userNameField.sendKeys(userName);

        LoggerClass.info("Podanie nazwy password do pola input");
        passwordField.sendKeys(password);

        LoggerClass.info("Wciśnięcie przycisku Zaloguj");
        loginButton.click();
    }

    public String getErrorMessage() {
        LoggerClass.warn("Pojawił się błąd");
        return errorMessage.getText();
    }
}
