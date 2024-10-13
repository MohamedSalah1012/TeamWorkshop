package ComponentTests;

import Bots.Bot;
import Pages.AfterDeleteAccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class ValidLoginTest {

    private WebDriver driver;
    ChromeOptions chromeOptions;
    String baseUrl ="https://automationexercise.com/",
     valid_email = "", valid_pass = "12345678";




    @Epic("Login")
    @Feature("Invalid Login")
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
    public void setUp(){
//        chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }


    @AfterClass
    public void tearDown() {
        if (driver!=null){
        driver.quit();
    }
    }

   @AfterMethod
    public void takeScreenShotOnFailure(ITestResult result) throws FileNotFoundException {
        Bot.handleScreenShot(driver , result);
   }

}
