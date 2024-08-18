package pages;

import  org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {
    WebDriver driver;

    // Logowanie
    @FindBy(xpath = "//input[@id='username']")
    WebElement userNameField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit' and @value='Zaloguj się']")
    WebElement loginButton;


    // Elementy strony
        @FindBy(xpath = "//a[text()='Zamówienia']")
        WebElement ordersLink;

        @FindBy(xpath = "//span[text()='Zamówienie']")
        WebElement ordersTitle;

    // Konstruktor klasy pages.OrdersPage
        public OrdersPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

    // Metody testów
    public void clickOrdersLinkAndAssercion(String userName, String password) {
        LoggerClass.info("Logowanie do aplikacji");
        LoggerClass.info("Podanie nazwy usera do pola input");
        userNameField.sendKeys(userName);

        LoggerClass.info("Podanie nazwy password do pola input");
        passwordField.sendKeys(password);

        LoggerClass.info("Wciśnięcie przycisku Zaloguj");
        loginButton.click();

        LoggerClass.info("Clicking on Orders Link");
        ordersLink.click();
        assert ordersTitle.isDisplayed();
    }
}
