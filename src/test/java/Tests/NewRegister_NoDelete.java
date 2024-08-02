package Tests;

import Pages.*;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class NewRegister_NoDelete {

    WebDriver driver;
    String baseUrl ="https://automationexercise.com/",
    username = "xyz",
    email="xyz@salah.com";


    @Description("This test for register a new user but will not delete the account")
    @Test( testName = " Register as a new user - with No delete account ")
    public void newRegister() {
        new HomePage(driver)
                .silderIsVisible()
                .clickOnSignupLoginLinkButton();

        new LoginPage(driver)
                .newUserSignUpHeader_Is_Visible()
                .enterUsernameAndEmail(username , email);

        new SignUpPage(driver)
                .signUpNewAccount("Mr","12345678","ahmed"
                        ,"salah","sting","cairo"
                        ,"Canada","giza","cairo","1565","01232652547");


        new AccountCreatedPage(driver)
                .accountCreatedHeaderisVisible()
                .clickContinueButton();

        new HomePage(driver)
                .verifyLoggedInLabelIsVisible();
    }


    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }



    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
