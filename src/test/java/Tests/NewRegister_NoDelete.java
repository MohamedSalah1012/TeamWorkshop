package Tests;

import Pages.*;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class NewRegister_NoDelete {

    WebDriver driver;
    String baseUrl ="https://automationexercise.com/",
    username = "mohamed salah",
    email="mo@salah.com";


    @Description("This test for register a new user but will not delete the account")
    @Test( testName = " Register as a new user - with No delete account ")
    public void newRegister() {
        new HomePage(driver)
                .silderIsVisible()
                .clickOnSignupLoginLinkButton();

        new LoginPage(driver)
                .newUserSignUpHeader_Is_Visible()
                .fillUserSignUpFrom(username , email);

        new SignUpPage(driver)
                .signUpFormLabel_IsVisible()
                .selectGender("Mr")
                .enterPassword("12345678")
                .checkNewsLetterCheckBox()
                .check_Receive_Special_Offer_CheckBox()
                .enterFirstName("mohamed")
                .enterLastName("salah")
                .enterCompany("ourcompany")
                .enterAddress("cairo")
                .select_Country_From_DropDownList("Canada")
                .otherfields("giza", "cairo", "5645", "+201032032144")
                .clickCreateAccountButton();


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
