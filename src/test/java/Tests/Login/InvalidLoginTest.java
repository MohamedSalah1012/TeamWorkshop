package Tests.Login;
import Pages.*;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
public class InvalidLoginTest {

    WebDriver driver;
    ChromeOptions chromeOptions;
    String invalid_email = "s@f.com" , invalid_pass = "1234";




    @Description("Login with Invalid credentials")
    @Test(testName = "Invalid Login with invalid email and invalid password" )
    public void invalidLogin(){

        new HomePage(driver)
                .checkSliderInHomePageIsVisible()
                .clickOnSignupLoginLinkButton();
        new LoginPage(driver)
                .loginHeader_Is_Visible()
                .loginWithValidCredentials(invalid_email , invalid_pass)
                .checkAlertMessageIsDisplayed();
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
