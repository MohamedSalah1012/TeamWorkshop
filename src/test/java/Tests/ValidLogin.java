package Tests;

import Pages.DeletedAccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ValidLogin {

    WebDriver driver;
    String valid_email = "mo@salah.com" , valid_pass = "12345678";




    @Description("")
    @Test(testName = "valid Login with valid email and valid password" )
    public void invalidLogin(){

        new HomePage(driver)
                .silderIsVisible()
                .clickOnSignupLoginLinkButton();
        new LoginPage(driver)
                .loginHeader_Is_Visible()
                .loginWithValidCredentials(valid_email , valid_pass)
                .checkAlertMessageIsDisplayed();
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
        driver.get("https://automationexercise.com");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
