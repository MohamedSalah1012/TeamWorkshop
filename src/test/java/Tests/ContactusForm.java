package Tests;

import org.openqa.selenium.WebDriver;
import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactusForm {

    WebDriver driver;
    String baseUrl ="https://automationexercise.com/";
    String name = "Mohamed",   email= "mohamed@test.com" ,subject= "complain", message=" i do complain",
            uploadedFile ="E:/Ouredu projects/images/download (4).png";




    @Test
    public void contactUs(){
        new HomePage(driver)
                .silderInHomePageIsVisible()
                .clickOnContactUsLink();




        new ContactUsPage(driver)
                .getInTouchHeaderIsVisible()
                .fillContactUsFormAndSubmit(name, email , subject , message ,uploadedFile)
                .successMessageIsVisible()
                .clickOnTheHomePageButton();
        new HomePage(driver)
                .silderInHomePageIsVisible();
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
