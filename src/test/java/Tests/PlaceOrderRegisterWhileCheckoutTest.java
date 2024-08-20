package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class PlaceOrderRegisterWhileCheckoutTest {

    private WebDriver driver;
    private String baseUrl ="https://automationexercise.com/";



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
                .enterUsernameAndEmailAndClickSignUp("uiyuiy" , "uiyuiy@test.com");

        new SignUpPage(driver)
                .signUpNewAccount("Mr" , "12345678","mohamed" , "salah","test",
                             "cairo", "1","cairo","cairo","165458","01212314648");

        new AccountCreatedPage(driver)
                .accountCreatedHeaderIsVisible()
                .clickOnContinueButton()
                .verifyLoggedInLabelIsVisible()
                .clickOnTheCartLink()
                .proceedToCheckoutWithoutLoggedInUser();

        new CheckoutPage(driver)
                .typeComment("amazing shopping")
                .clickOnPlaceOrder();

        new PaymentPage(driver)
                .enterYourCredentials("test","1649898","123","12","2026");

        new AfterPaymentPage(driver)
                .verifyAfterPaymentSuccessMessageIsDisplayed();

        new HomePage(driver)
                .clickOnTheDeleteLink();

        new AfterDeleteAccountPage(driver)
                .deletedAccountTextIsDisplayed()
                .clickOnContinueButton();
    }



    @BeforeClass
    public void setUp(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }



    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
