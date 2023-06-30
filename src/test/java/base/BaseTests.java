package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HomePage;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    @BeforeEach
    public void setUp() {
        System.setProperty("webdrive.chrome.drive", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
//        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//        driver.quit();
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    public static void main(String[] args) {
        BaseTests test = new BaseTests();
        test.setUp();
    }
}
