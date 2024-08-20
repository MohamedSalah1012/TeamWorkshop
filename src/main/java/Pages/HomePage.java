package Pages;
import Bots.ActionBot;
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
    private final By cartLink           = By.xpath("//a[@href='/view_cart' and text()=' Cart']");
    private final By subscriptionHeader = By.xpath("//h2[contains(text(),\"Subscription\")]");
    private final By subscriptionInput   = By.xpath("//input[@id=\"susbscribe_email\"]");
    private final By submitSubsriptionButton   = By.xpath("//button[@id='subscribe']");

    private final By testCasesLink = By.xpath("(//a[@href='/test_cases'])[1]");

    //Xpath to get view product button of items in home page by item order
    private By viewProductButton(int productOrder){
        return By.xpath("//a[@href='/product_details/"+productOrder+"']");
    }

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


    public CartPage clickOnTheCartLink(){
        ActionBot.clicking(driver , cartLink);
        return new CartPage(driver);
    }
    public ContactUsPage clickOnContactUsLink(){
        ActionBot.clicking(driver, contactUsLink);
        return new ContactUsPage(driver);
    }
    public AfterDeleteAccountPage clickOnTheDeleteLink(){
        ActionBot.clicking(driver , deleteLink);
        return new AfterDeleteAccountPage(driver);
    }
    public TestCasesPage clickOnTestcasesLink(){
        ActionBot.clicking(driver, testCasesLink);
        return new TestCasesPage(driver);
    }



    //////// Methods//////////
    public HomePage verifyTextSubscriptionAndSubscribe(String email){
        ActionBot.isVisible(driver , subscriptionHeader);
        ActionBot.enterText(driver , subscriptionInput , email );
        ActionBot.clicking(driver , submitSubsriptionButton);
        return this;
    }

    public ProductDetailsPage clickOnviewProductButton(int productOrder){
        ActionBot.clicking(driver,viewProductButton(productOrder));
        return new ProductDetailsPage(driver);
    }

}