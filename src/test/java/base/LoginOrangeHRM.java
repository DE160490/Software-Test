package base;

import model.empty.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginOrangeHRM {

    private WebDriver driver = new ChromeDriver();

    public List<Account> listAccount(){
        List<Account> list = new ArrayList<>();
        list.add(new Account("Admin", "admin123"));
        list.add(new Account("Admin", "admin1234"));
        list.add(new Account("User", "admin123"));
        list.add(new Account("User", "admin1234"));
        list.add(new Account("", ""));
        list.add(new Account("", "admin123"));
        list.add(new Account("Admin", ""));
        return list;
    }

    public void Login(){

        System.setProperty("webdrive.chrome.drive", "resources/chromedriver.exe");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
//
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");
//        oxd-input oxd-input--active
//        System.out.println(username);

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
//        oxd-input oxd-input--active

        List<WebElement> list = driver.findElements(By.tagName("input"));
        for (WebElement l: list
             ) {
            System.out.println("Element: " + l.getAttribute("username"));
        }
        driver.findElement(By.xpath("//button[contains(text(),' Login ']")).click();
        driver.navigate().back();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.quit();
    }

    public static void main(String[] args) {
        LoginOrangeHRM login = new LoginOrangeHRM();
        login.Login();
    }
}
