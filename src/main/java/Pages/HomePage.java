package Pages;
import Bots.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }



    ///// Locators /////

    private final By signUpLink = By.xpath("//a[@href='/login']");

    private final By silder = By.xpath("(//div[@class='carousel-inner'])[1]");


    public HomePage silderIsVisible(){
        ActionBot.isVisible(driver,silder);
        return new HomePage(driver);
    }


    public Login clickOnSignupLinkButton(){
        ActionBot.clicking(driver, signUpLink);
        return  new Login(driver);
    }
}
