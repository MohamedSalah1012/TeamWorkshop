package Tests.Login;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class ValidLoginTest {

    WebDriver driver;
    ChromeOptions chromeOptions;
    String baseUrl ="https://automationexercise.com/",
     valid_email = "mo@salah.com", valid_pass = "12345678";





    @Test(testName = "Valid Login with Valid email and Valid password" )
    public void invalidLogin(){

        new HomePage(driver)
                .checkSliderInHomePageIsVisible()
                .clickOnSignupLoginLinkButton();
        new LoginPage(driver)
                .loginHeader_Is_Visible()
                .loginWithValidCredentials(valid_email , valid_pass);
        new HomePage(driver)
                .verifyLoggedInLabelIsVisible()
                .clickOnTheDeleteLink();
        new AfterDeleteAccountPage(driver)
                .deletedAccountHeaderIsDisplayed();
    }







    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser){
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to(HomePage.expectedHomePageUrl);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.navigate().to(HomePage.expectedHomePageUrl);
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
