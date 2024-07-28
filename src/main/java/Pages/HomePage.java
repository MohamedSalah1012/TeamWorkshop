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

    private final By loggedInAsLabel = By.xpath("//li//a[contains(text(),' Logged in as ')]");

    private final By deleteLink = By.xpath("//a[@href='/delete_account']");


    public HomePage silderIsVisible(){
        ActionBot.isVisible(driver,silder);
        return this;
    }


    public LoginPage clickOnSignupLinkButton(){
        ActionBot.clicking(driver, signUpLink);
        return  new LoginPage(driver);
    }

    public HomePage verifyLoggedInLabelIsVisible(){
        ActionBot.isVisible(driver , loggedInAsLabel);
        return this;
    }

    public DeletedAccountPage clickTheDeleteLink(){
        ActionBot.clicking(driver , deleteLink);
        return new DeletedAccountPage(driver);
    }
}
