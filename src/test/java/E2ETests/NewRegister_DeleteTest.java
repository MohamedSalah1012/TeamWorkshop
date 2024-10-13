package E2ETests;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class NewRegister_DeleteTest {

    WebDriver driver;

    @Test( testName = " Register as a new user and delete account ")
    public void newRegister(){


        new HomePage(driver)
                .checkThePageUrlIsValid()
                .checkSliderInHomePageIsVisible()
                .clickOnSignupLoginLinkButton();

        new LoginPage(driver)
                .newUserSignUpHeader_Is_Visible()
                .enterUsernameAndEmailAndClickSignUp(TestData.username , TestData.emailAddress);

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
