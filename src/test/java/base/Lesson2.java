package base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Lesson2 {
    private WebDriver driver;
    public void setUp(){
        System.setProperty("webdrive.chrome.drive", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
//        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(375, 812));
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.quit();
    }

    public static void main(String[] args) {
        Lesson2 lesson2 = new Lesson2();
        lesson2.setUp();
    }
}
