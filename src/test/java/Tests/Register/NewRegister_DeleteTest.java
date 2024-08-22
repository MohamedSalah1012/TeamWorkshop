package Tests.Register;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class NewRegister_DeleteTest {

    WebDriver driver;
    ChromeOptions chromeOptions;

    @Test( testName = " Register as a new user and delete account ")
    public void newRegister(){


        new HomePage(driver)
                .checkThePageUrlIsValid()
                .checkSliderInHomePageIsVisible()
                .clickOnSignupLoginLinkButton();

        new LoginPage(driver)
                .newUserSignUpHeader_Is_Visible()
                .enterUsernameAndEmailAndClickSignUp("new6" , "new6@user6.com" );

        new SignUpPage(driver)
                .signUpNewAccount("Mr","12345678","mohamed"
                                 ,"salah","sting","cairo"
                                 ,"Canada","giza","cairo","1565","01232652547");


        new AfterCreateAccountPage(driver)
                .accountCreatedHeaderIsVisible()
                .clickOnContinueButton();

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
