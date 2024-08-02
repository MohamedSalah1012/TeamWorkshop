package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ValidLogin {

    WebDriver driver;
    String baseUrl ="https://automationexercise.com/",
     valid_email = "mo@salah.com", valid_pass = "12345678";





    @Test(testName = "Valid Login with Valid email and Valid password" )
    public void invalidLogin(){

        new HomePage(driver)
                .silderInHomePageIsVisible()
                .clickOnSignupLoginLinkButton();
        new LoginPage(driver)
                .loginHeader_Is_Visible()
                .loginWithValidCredentials(valid_email , valid_pass);
        new HomePage(driver)
                .verifyLoggedInLabelIsVisible()
                .clickTheDeleteLink();
        new DeletedAccountPage(driver)
                .deletedAccountTextIsDisplayed();
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
