package Tests.Random;

import org.openqa.selenium.WebDriver;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class ContactUsFormTest {

   private WebDriver driver;
    ChromeOptions chromeOptions;
    String baseUrl ="https://automationexercise.com/";
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
