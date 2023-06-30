package test;

import function.LoginHRM;
import model.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class TestLogin {

    public List<Account> listDataLogin(){
        List<Account> list = new ArrayList<>();
        list.add(new Account("Admin","admin123", "1"));
        list.add(new Account("Admin","admin1234", "2"));
        list.add(new Account("User","admin123", "3"));
        list.add(new Account("User","admin1234", "4"));
        list.add(new Account("","", "5"));
        list.add(new Account("","admin123", "6"));
        list.add(new Account("User","", "7"));
        return list;
    }

    public void executeLogin(String username, String password, String alert){
//        Set Property for system, not use because had use in pom.xml
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        Declare value for WebDriver "Select Chrome"
        WebDriver driver = new ChromeDriver();
//        Set link to open web
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        Set Width and Height Window when open
        driver.manage().window().maximize();
//        Call function in function class LoginHRM
        LoginHRM login = new LoginHRM(driver);
//        Set Username
        login.getWaitingExecution();
        login.setUserName(username);
//        Set Password
        login.getWaitingExecution();
        login.setPassword(password);
//        Set Button Login
        login.getWaitingExecution();
        login.setClickButton();
//        Get Result Alert
        login.getWaitingExecution();
        System.out.println(login.getResultAlert(alert));
//        Come Back Page Before
        login.getWaitingExecution();
        driver.navigate().back();
//        Close Window
        driver.quit();
    }

    public static void main(String[] args) {
        TestLogin login = new TestLogin();
        List<Account> list = login.listDataLogin();
        for (Account a: list) {
            login.executeLogin(a.getUsername(),a.getPassword(), a.getAlert());
        }
    }
}
