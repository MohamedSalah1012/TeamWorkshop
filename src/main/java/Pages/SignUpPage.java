package Pages;
import Bots.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {


    private  WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    ///// Locators //////

    By enterAccountInfoLabel = By.xpath("//b[contains(text(),'Enter Account Information')]");




    public SignUpPage AccountInfoLabelIsVisible(){
        ActionBot.isVisible(driver , enterAccountInfoLabel);
        return new SignUpPage(driver);
    }
}
