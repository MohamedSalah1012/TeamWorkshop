package ComponentTests;

import Pages.HomePage;
import Pages.TestCasesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyTestCasesPageTest {
    WebDriver driver;
    String baseUrl ="https://automationexercise.com/";

    @Test(testName = "Verify Test Cases Page")
    public void caseVerifyTestCasesPage(){
        new HomePage(driver).checkSliderInHomePageIsVisible().clickOnTestcasesLink();

        new TestCasesPage(driver).testCaseHeaderIsVisiable();
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
