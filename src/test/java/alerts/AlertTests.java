//package alerts;
//
//import base.BaseTests;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//public class AlertTests extends BaseTests {
//    @Test
//    public void testAcceptAlert(){
//        var alertPage = homePage.clickJavaScriptAlerts();
//        alertPage.clickButtonJSAlert();
//        alertPage.acceptJSAlert();
//        Assertions.assertEquals(alertPage.getAlertResult(), "You successfully clicked an alert", "Result alert is incorrect!");
//    }
//    @Test
//    public void testConfirmAlert(){
//        var alertPage = homePage.clickJavaScriptAlerts();
//        alertPage.clickButtonJSConfirm();
//        String text = alertPage.getAlertText();
//        alertPage.clickToCancel();
//        Assertions.assertEquals(text, "I am a JS Confirm", "Alert text is incorrect!");
//    }
//    @Test
//    public void testPromptAlert(){
//        var alertPage = homePage.clickJavaScriptAlerts();
//        alertPage.clickButtonJSPrompt();
//        String textToInput = "thanhncde160490@fpt.edu.vn";
//        alertPage.sendTextToAlert(textToInput);
//        alertPage.acceptJSAlert();
//        Assertions.assertEquals(alertPage.getAlertResult(), "You entered: " + textToInput ,"Result text is incorrect!");
//    }
//}