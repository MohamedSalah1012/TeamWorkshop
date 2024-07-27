package Tests;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class NewRegister {

    WebDriver driver;


    @Test( testName = "New Register")
    public void sliderIsVisible(){
        new HomePage(driver)
                .silderIsVisible()
                .clickOnSignupLinkButton();
        new Login(driver)
                .newUserSignUpHeader_Is_Visible()
                .fillUserSignUpFrom("MS" , "mn@s.com" );
        new SignUpPage(driver)
                .signUpFormLabelIsVisible()
                .selectGender("Mrs")
                .enterPassoword("12345678")
                .checkNewsLetterCheckBox()
                .checkReceiveSpecialOfferCheckBox()
                .enterFirstName("Mohamed")
                .enterLastName("Salah")
                .enterCompany("ourteam");
    }






    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
    }



//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }
}
