package function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.TestLogin;

public class MyInfo {
    private WebDriver driver;

    public MyInfo(WebDriver driver) {
        this.driver = driver;
    }

    private By selectMyInfo = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a");
    public void selectMyInfoMenu(){driver.findElement(selectMyInfo).click();}

    private By selectPersonalDetail = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[1]/a");
    public void setSelectPersonalDetailTab(){driver.findElement(selectPersonalDetail).click();}

    private By firstName = By.name("firstName");
    public void setFirstName(String firstNameInput){
        System.out.println("Get values: " + driver.findElement(firstName).getAttribute("value"));
        driver.findElement(firstName).clear();
        try{
            Thread.sleep(5000);
            System.out.println("Get values: " + driver.findElement(firstName).getAttribute("value"));
            Thread.sleep(5000);
            driver.findElement(firstName).getAttribute("value");
            System.out.println("Time Wait Clear. 1 Second");
        } catch(InterruptedException ie){
            System.err.println("Error: " + ie);
        }
        driver.findElement(firstName).sendKeys(firstNameInput);
    }

    private By middleName = By.name("middleName");
    public void setMiddleName(String middleNameInput){
        driver.findElement(middleName).clear();
        try{
            Thread.sleep(5000);
            System.out.println("Time Wait Clear. 1 Second");
        } catch(InterruptedException ie){
            System.err.println("Error: " + ie);
        }
        driver.findElement(middleName).sendKeys(middleNameInput);
    }

    private By lastName = By.name("lastName");
    public void setLastName(String lastNameInput){
        driver.findElement(lastName).clear();
        try{
            Thread.sleep(5000);
            System.out.println("Time Wait Clear. 1 Second");
        } catch(InterruptedException ie){
            System.err.println("Error: " + ie);
        }
        driver.findElement(lastName).sendKeys(lastNameInput);
    }

    private By buttonSave = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[5]/button");
    public void clickButtonSave(){driver.findElement(buttonSave).click();}

    public void testEmployeeFullName(String firstname, String middlename, String lastname){
//        Set Property for system, not use because had use in pom.xml
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
////        Declare value for WebDriver "Select Chrome"
//        WebDriver driver = new ChromeDriver();
//        Set link to open web
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//        Set Width and Height Window when open
        driver.manage().window().maximize();
//        Login before test edit profile
        LoginHRM login = new LoginHRM(driver);
        login.getWaitingExecution();
        login.setUserName("Admin");
        login.getWaitingExecution();
        login.setPassword("admin123");
        login.getWaitingExecution();
        login.setClickButton();
//        Start Test
        login.getWaitingExecution();
        selectMyInfoMenu();
        login.getWaitingExecution();
        setSelectPersonalDetailTab();
        login.getWaitingExecution();
        setFirstName(firstname);
        login.getWaitingExecution();
        setMiddleName(middlename);
        login.getWaitingExecution();
        setLastName(lastname);
        login.getWaitingExecution();
        clickButtonSave();
        driver.quit();
    }
}
