package Tests;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class SubscriptionTest {

    WebDriver driver;
    ChromeOptions chromeOptions;
    String baseUrl ="https://automationexercise.com/",
           subscribedEmail ="test@subscribe.com";




    @Test(testName = "Verify subscription in home page")
    public void subscribe(){
        new HomePage(driver)
                .silderInHomePageIsVisible()
                .verifyTextSubscriptionAndSubscribe(subscribedEmail)
                .silderInHomePageIsVisible();
    }





    @BeforeClass
    public void setUp(){
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver =new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
