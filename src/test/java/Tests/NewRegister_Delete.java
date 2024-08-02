package Tests;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class NewRegister_Delete {

    WebDriver driver;
    String baseUrl ="https://automationexercise.com/";

    @Test( testName = " Register as a new user and delete account ")
    public void newRegister(){
        new HomePage(driver)
                .silderIsVisible()
                .clickOnSignupLoginLinkButton();

        new LoginPage(driver)
                .newUserSignUpHeader_Is_Visible()
                .fillUserSignUpFrom("new6" , "new6@user6.com" );

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
                .selectCountry("United States")
//                .select_Country_From_DropDownList("Canada")
                .otherfields("giza","cairo","5645","+201032032144")
                .clickCreateAccountButton();


        new AccountCreatedPage(driver)
                .accountCreatedHeaderisVisible()
                .clickContinueButton();

        new HomePage(driver)
                .verifyLoggedInLabelIsVisible()
                .clickTheDeleteLink();

        new DeletedAccountPage(driver)
                .deletedAccountTextIsDisplayed();
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
