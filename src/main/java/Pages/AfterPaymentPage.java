package Pages;

import Bots.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AfterPaymentPage {
    private  WebDriver driver ;

    public AfterPaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By afterPaymentSuccessedMessage = By.xpath("//div/p[text()='Congratulations! Your order has been confirmed!']");




    public AfterPaymentPage verifyAfterPaymentSuccessMessageIsDisplayed(){
        String expectedMessage = "Congratulations! Your order has been confirmed!";
        String actualMessage = driver.findElement(afterPaymentSuccessedMessage).getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
        return this;
    }


}
