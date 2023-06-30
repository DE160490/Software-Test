package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage {
    private WebDriver driver;
    private By buttonJSAlert = By.xpath("//button[contains(text(),'Click for JS Alert')]");
    private By buttonJSConfirm = By.xpath("//button[contains(text(),'Click for JS Confirm')]");
    private By buttonJSPrompt = By.xpath("//button[contains(text(),'Click for JS Prompt')]");
    public AlertPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickButtonJSAlert(){
        driver.findElement(buttonJSAlert).click();
    }
    public void acceptJSAlert(){
        driver.switchTo().alert().accept();
    }

    public void clickButtonJSConfirm(){
        driver.findElement(buttonJSConfirm).click();
    }
    public void clickToCancel(){
        driver.switchTo().alert().dismiss();
    }
    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }

    public void clickButtonJSPrompt(){
        driver.findElement(buttonJSPrompt).click();
    }
    public void sendTextToAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }

}