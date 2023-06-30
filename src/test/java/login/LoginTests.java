package login;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTests extends BaseTests {
    @Test
    @DisplayName("TC01-Login successfully")
    public void testLoginSuccessfully(){
        LoginPage loginPage = homePage.clickFormAuthenticantion();
        loginPage.setUserName("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        String alertText = secureAreaPage.getAlertText();
        Assertions.assertTrue(alertText.contains("You logged into a secure area!"), "Alert text is incorrect!");
    }
}