package Tests.Random;

import org.openqa.selenium.WebDriver;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class ContactUsFormTest {

   private WebDriver driver;
    ChromeOptions chromeOptions;
    String name = "Mohamed",   email= "mohamed@test.com" ,subject= "complain", message=" i do complain",
            uploadedFile ="E:/Ouredu projects/images/download (4).png";




    @Test
    public void contactUs(){
        new HomePage(driver)
                .checkSliderInHomePageIsVisible()
                .clickOnContactUsLink();




        new ContactUsPage(driver)
                .getInTouchHeaderIsVisible()
                .fillContactUsFormAndSubmit(name, email , subject , message ,uploadedFile)
                .successMessageIsVisible()
                .clickOnTheHomePageButton();
        new HomePage(driver)
                .checkSliderInHomePageIsVisible();
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
