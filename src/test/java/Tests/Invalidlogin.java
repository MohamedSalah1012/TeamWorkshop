package Tests;
import Pages.*;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
public class Invalidlogin {

    WebDriver driver;
    String baseUrl = "https://automationexercise.com",
     invalid_email = "s@f.com" , invalid_pass = "1234";




    @Description("Login with Invalid credentials")
    @Test(testName = "Invalid Login with invalid email and invalid password" )
    public void invalidLogin(){

        new HomePage(driver)
                .silderIsVisible()
                .clickOnSignupLoginLinkButton();
        new LoginPage(driver)
                .loginHeader_Is_Visible()
                .loginWithValidCredentials(invalid_email , invalid_pass)
                .checkAlertMessageIsDisplayed();
    }







    @BeforeClass
    public void setUp(){
        driver =new ChromeDriver() ;
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
