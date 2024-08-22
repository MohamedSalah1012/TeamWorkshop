package Tests.Random;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class SubscriptionTest {

    WebDriver driver;
    ChromeOptions chromeOptions;
    String baseUrl ="https://automationexercise.com/",
           subscribedEmail ="test@subscribe.com";




    @Test(testName = "Verify subscription in home page")
    public void subscribe(){
        new HomePage(driver)
                .checkSliderInHomePageIsVisible()
                .verifyTextSubscriptionAndSubscribe(subscribedEmail)
                .checkSliderInHomePageIsVisible();
    }





    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser){
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to(baseUrl);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.navigate().to(baseUrl);
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
