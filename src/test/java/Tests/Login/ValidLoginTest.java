package Tests.Login;

import Bots.ActionBot;
import Pages.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ValidLoginTest {

    WebDriver driver;
    ChromeOptions chromeOptions;
    String baseUrl ="https://automationexercise.com/",
     valid_email = "", valid_pass = "12345678";





    @Test(testName = "Valid Login with Valid email and Valid password" )
    public void invalidLogin(){

        new HomePage(driver)
                .checkSliderInHomePageIsVisible()
                .clickOnSignupLoginLinkButton();
        new LoginPage(driver)
                .loginHeader_Is_Visible()
                .loginWithValidCredentials(valid_email , valid_pass);
        new HomePage(driver)
                .verifyLoggedInLabelIsVisible()
                .clickOnTheDeleteLink();
        new AfterDeleteAccountPage(driver)
                .deletedAccountHeaderIsDisplayed();
    }







    @BeforeClass
    public void setUp(){
//        chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public  void takeScreenShotOnFailure (ITestResult result){
        if (ITestResult.FAILURE == result.getStatus()) {
            var cam = (TakesScreenshot) driver;
            File screenshot = cam.getScreenshotAs(OutputType.FILE);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy  HH-mm-ss"));
            try {
                Files.move(screenshot.toPath(), new File("Screenshots/" + result.getName() + " " + timestamp + ".png").toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
