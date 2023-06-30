package function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHRM {
    private WebDriver driver;

    public LoginHRM(WebDriver driver) {
        this.driver = driver;
    }

    private By username = By.name("username");
    private By password = By.name("password");
    private By button = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");

    public void setUserName(String usernameKey){
        driver.findElement(username).sendKeys(usernameKey);
    }
    public void setPassword(String passwordKey) { driver.findElement(password).sendKeys(passwordKey); }
    public void setClickButton(){driver.findElement(button).click();}

    private By successLogin = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6");
    public String getAlertLoginSuccsess(){
        if (successLogin != null) return "Login Success: " + driver.findElement(successLogin).getText();
        return "Not Found Alert";}

    private By failLogin = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p");
    public String getAlertLoginFail(){
        if (failLogin != null) return "Login Fail: " + driver.findElement(failLogin).getText();
        return "Not Found Alert";}

    private By emptyUsername = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span");
    public String getAlertUsernameEmpty(){return "Login Fail: " + driver.findElement(emptyUsername).getText();}

    private By emptyPassword = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span");
    public String getAlertPasswordEmpty(){return "Login Fail: " + driver.findElement(emptyPassword).getText();}

    public String getResultAlert(String alert){
        if (alert.equals("1")){
            return getAlertLoginSuccsess();
        }else if(alert.equals("2") || alert.equals("3") || alert.equals("4")){
            return getAlertLoginFail();
        }else if (alert.equals("5")){
            return getAlertUsernameEmpty() + getAlertPasswordEmpty();
        }else if (alert.equals("6")){
            return getAlertUsernameEmpty();
        }else if (alert.equals("7")){
            return getAlertPasswordEmpty();
        }
        return "Not Pass: Because Message Not Read";
    }

    public void getWaitingExecution(){
        // Waiting Before And After Execution
        try{
            Thread.sleep(2000);
            System.out.println("Time Wait Execution. 2 Second");
        } catch(InterruptedException ie){
            System.err.println("Error: " + ie);
        }
    }
}
