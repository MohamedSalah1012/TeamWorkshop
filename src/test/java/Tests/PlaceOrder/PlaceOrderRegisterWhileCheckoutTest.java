package Tests.PlaceOrder;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class PlaceOrderRegisterWhileCheckoutTest {

    private WebDriver driver;
    private final String baseUrl ="https://automationexercise.com/";





    @Test(testName = "place order: Register while checkout out")
    public void RegisterWhileCheckout(){
        new HomePage(driver)
                .checkSliderInHomePageIsVisible();

        new ProductsPage(driver)
                .directClickAddProductToCart(1)
                .clickOnViewCart();

        new CartPage(driver)
                .verifyShoppingCartText()
                .proceedToCheckoutWithoutLoggedInUser()
                .clickOnRegisterLink();

        new LoginPage(driver)
                .newUserSignUpHeader_Is_Visible()
                .enterUsernameAndEmailAndClickSignUp(TestData.username, TestData.emailAddress);

        new SignUpPage(driver)
                .signUpNewAccount("Mr" , TestData.password, TestData.firstName , TestData.lastName,TestData.company,
                             TestData.country, "1", TestData.country, TestData.country , TestData.zipCode , TestData.mobileNumber);

        new AfterCreateAccountPage(driver)
                .accountCreatedHeaderIsVisible()
                .clickOnContinueButton()
                .verifyLoggedInLabelIsVisible()
                .clickOnTheCartLink()
                .proceedToCheckoutWithoutLoggedInUser();

        new CheckoutPage(driver)
                .checkTableHeadersArePresent(CheckoutPage.validTableHeaders)
                .typeComment("amazing shopping")
                .clickOnPlaceOrder();

        new PaymentPage(driver)
                .enterYourCredentials("test",TestData.creditCardNumber,"123","12","2026");

        new AfterPaymentPage(driver)
                .verifyAfterPaymentSuccessMessageIsDisplayed("Congratulations! Your order has been confirmed!");

        new HomePage(driver)
                .clickOnTheDeleteLink();

        new AfterDeleteAccountPage(driver)
                .deletedAccountHeaderIsDisplayed()
                .clickOnContinueButton()
                .checkSliderInHomePageIsVisible();
    }



    @BeforeClass
    public void setUp(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HomePage.expectedHomePageUrl);
    }



    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
