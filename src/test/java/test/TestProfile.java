package test;

import function.MyInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestProfile {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();;
        MyInfo myInfo = new MyInfo(driver);
        myInfo.testEmployeeFullName("I", "Love", "You");
    }
}
