package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class Lesson3 {
    private WebDriver driver;
    public void setUp(){
        System.setProperty("webdrive.chrome.drive", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().setSize(new Dimension(375, 812));
        System.out.println(driver.getTitle());

        WebElement userNameElement = driver.findElement(By.id("username"));
        userNameElement.sendKeys("tomsmith");
        WebElement passwordElement = driver.findElement(By.id("password"));
        passwordElement.sendKeys("SuperSecretPassword!");

        System.out.println("Name attribute of username button: " + userNameElement.getAttribute("name"));
//        driver.findElement(By.xpath("//i[contains(text(),'Login']")).click();
        driver.findElement(By.xpath("//i[contains(text(), 'Login')]")).click();
        driver.navigate().back();

        List<WebElement> inputList = driver.findElements(By.tagName("input"));
        System.out.println(inputList.size());

        for (WebElement element: inputList) {
            System.out.println("Element: " + element.getAttribute("name"));
        }
        for (int i = 0; i < inputList.size(); i++) {
            System.out.println("Element: " + inputList.get(i).getAttribute("name"));
        }

                try{
            System.out.println("Run 3: Wait 3 Second");
            Thread.sleep(3000);
        } catch(InterruptedException ie){
            System.err.println("Error: " + ie);
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.quit();
    }

    public static void main(String[] args) {
        Lesson3 lesson3 = new Lesson3();
        lesson3.setUp();
    }
}
