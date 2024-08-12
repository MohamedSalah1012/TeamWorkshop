package Pages;
import Bots.ActionBot;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {

    private  WebDriver driver;
    public static final String expectedHomePageUrl = "https://automationexercise.com/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }





                                            //////// Locators ////////

    private final By signUpLink         = By.xpath("//a[@href='/login']");

    private final By contactUsLink      = By.xpath("//a[@href='/contact_us']");

    private final By silder             = By.xpath("(//div[@class='carousel-inner'])[1]");

    private final By loggedInAsLabel    = By.xpath("//li//a[contains(text(),' Logged in as ')]");

    private final By deleteLink         = By.xpath("//a[@href='/delete_account']");

    private final By productsPageLink   = By.xpath("//a[@href='/products']");

    private final By subscriptionHeader = By.xpath("//h2[contains(text(),\"Subscription\")]");

    private final By subscriptionInput   = By.xpath("//input[@id=\"susbscribe_email\"]");

    private final By submitSubsriptionButton   = By.xpath("//button[@id='subscribe']");



                                        //////// Validations //////////

    public HomePage checkThePageUrlIsValid(){
       if(!driver.getCurrentUrl().equals(expectedHomePageUrl))
        throw new IllegalStateException("The expected url is: " + expectedHomePageUrl + "but we found another url");
        return this;
    }

    public HomePage checkSliderInHomePageIsVisible(){
        ActionBot.isVisible(driver,silder);
         return this;
    }

    public HomePage verifyLoggedInLabelIsVisible(){
        ActionBot.isVisible(driver , loggedInAsLabel);
        return this;
    }




                                        //////// Links In Navbar//////////

    public LoginPage clickOnSignupLoginLinkButton(){
        ActionBot.clicking(driver, signUpLink);
        return  new LoginPage(driver);
    }

    public ProductsPage clickOnTheProductsLink(){
        ActionBot.clicking(driver , productsPageLink);
        return new ProductsPage(driver);
    }


    public ContactUsPage clickOnContactUsLink(){
        ActionBot.clicking(driver, contactUsLink);
        return new ContactUsPage(driver);
    }

    public DeletedAccountPage clickOnTheDeleteLink(){
        ActionBot.clicking(driver , deleteLink);
        return new DeletedAccountPage(driver);
    }







                                         //////// Methods//////////
    public HomePage verifyTextSubscriptionAndSubscribe(String email){
        ActionBot.isVisible(driver , subscriptionHeader);
        ActionBot.enterText(driver , subscriptionInput , email );
        ActionBot.clicking(driver , submitSubsriptionButton);
        return this;
    }

}
