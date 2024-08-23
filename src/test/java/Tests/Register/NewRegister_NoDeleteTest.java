package Tests.Register;

import Pages.*;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class NewRegister_NoDeleteTest {

    WebDriver driver;
    ChromeOptions chromeOptions;
    String baseUrl ="https://automationexercise.com/",
    username = "tug",
    email="tug@salah.com";


    @Description("This test for register a new user but will not delete the account")
    @Test( testName = " Register as a new user - with No delete account ")
    public void newRegister() {
        new HomePage(driver)
                .checkSliderInHomePageIsVisible()
                .clickOnSignupLoginLinkButton();

        new LoginPage(driver)
                .newUserSignUpHeader_Is_Visible()
                .enterUsernameAndEmailAndClickSignUp(username , email);

        new SignUpPage(driver)
                .signUpNewAccount("Mr","12345678","ahmed"
                        ,"salah","sting","cairo"
                        ,"Canada","giza","cairo","1565","01232652547");


        new AfterCreateAccountPage(driver)
                .accountCreatedHeaderIsVisible()
                .clickOnContinueButton();

        new HomePage(driver)
                .verifyLoggedInLabelIsVisible();
    }


    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser ){
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.navigate().to(HomePage.expectedHomePageUrl);
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            driver.navigate().to(HomePage.expectedHomePageUrl);
            driver.manage().window().maximize();
        }
    }



    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
