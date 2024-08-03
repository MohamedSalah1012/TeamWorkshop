package Tests;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class SubscriptionTest {

    WebDriver driver;
    String baseUrl ="https://automationexercise.com/",
           subscribedEmail ="test@subscribe.com";




    @Test(testName = "Verify subscription in home page")
    public void subscribe(){
        new HomePage(driver)
                .silderInHomePageIsVisible()
                .verifyTextAndSubscribe(subscribedEmail)
                .silderInHomePageIsVisible();
    }





    @BeforeClass
    public void setUp(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
