package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.util.NoSuchElementException;

import java.util.concurrent.TimeUnit;

public class Lesson4 {
    private WebDriver driver;
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();

        System.out.println("Start: Wait");
////        Cách 1:
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));
        System.out.println("Text In Web: " + driver.findElement(By.id("finish")).getText());
        System.out.println("Run 1: Wait 3 Second");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

////        Cách 2:
//        System.out.println("Run 2: Wait 20 Second");
//        FluentWait waitFluent = new FluentWait(driver).withTimeout(20,TimeUnit.SECONDS)
//                .pollingEvery(2,TimeUnit.SECONDS)
//                .ignoring(NoSuchElementException.class);
//        waitFluent.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));

////        Cách 3:
//        try{
//            System.out.println("Run 3: Wait 3 Second");
//            Thread.sleep(3000);
//        } catch(InterruptedException ie){
//            System.err.println("Error: " + ie);
//        }

////        Cách 4:
//        WebDriverWait wait = new WebDriverWait(driver,20);
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));
//        System.out.println("Text In Web: " + driver.findElement(By.id("finish")).getText());
//        System.out.println("Run 4: Wait 30 Second");
//        System.out.println("Not Acction");
//        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);

////       Cách 5: Ko dùng đc
//        driver.manage().timeouts().setScriptTimeout(30,TimeUnit.SECONDS);

        driver.quit();
    }

    public static void main(String[] args) {
        Lesson4 lesson4 = new Lesson4();
        lesson4.setUp();
    }
}
