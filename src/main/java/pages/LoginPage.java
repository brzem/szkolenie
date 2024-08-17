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


    //Konstruktor klasy LoginPage
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);


    }

    //Metody do interackji na stronie
    public void setUserName(String userName) {
        userNameField.sendKeys(userName);
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);

    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
