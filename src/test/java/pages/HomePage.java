package pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By formLoginLink = By.linkText("Form Authentication");
    private By javaScriptAlertLink = By.linkText("JavaScript Alerts");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickFormAuthenticantion(){
        driver.findElement(formLoginLink).click();
        return new LoginPage(driver);
    }

    public AlertPage clickJavaScriptAlerts(){
        driver.findElement(javaScriptAlertLink).click();
        return new AlertPage(driver);
    }
}