package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By userNameTxt = By.id("username");
    private By passwordTxt = By.id("password");
    private By loginButton = By.cssSelector("#login button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String userName) {
        driver.findElement(userNameTxt).sendKeys(userName);
    }

    public void setPassword(String password) {
        driver.findElement(passwordTxt).sendKeys(password);
    }

    public SecureAreaPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }
}