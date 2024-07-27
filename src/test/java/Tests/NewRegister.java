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
        new Login(driver)
                .newUserSignUpHeader_Is_Visible()
                .fillUserSignUpFrom("new" , "new@user1.com" );
        new SignUpPage(driver)
                .signUpFormLabelIsVisible()
                .selectGender("Mrs")
                .enterPassoword("12345678")
                .checkNewsLetterCheckBox()
                .checkReceiveSpecialOfferCheckBox()
                .enterFirstName("Mohamed")
                .enterLastName("Salah")
                .enterCompany("ourteam")
                .enterAddress("cairo")
                .select_From_DropDownList("Canada")
                .otherfield("cairo" , "cairo","45645","+201032024588")
                .clickCreateAccountButton();
        new AccountCreated(driver)
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



//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }
}
