package Tests;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class NewRegister {

    WebDriver driver;
    String baseUrl ="https://automationexercise.com/";


    @Test( testName = "New Register")
    public void sliderIsVisible(){
        new HomePage(driver)
                .silderIsVisible()
                .clickOnSignupLinkButton();

        new LoginPage(driver)
                .newUserSignUpHeader_Is_Visible()
                .fillUserSignUpFrom("new5" , "new5@user5.com" );

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
