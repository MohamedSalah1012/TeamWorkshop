package Tests.TestCases;

import Pages.HomePage;
import Pages.TestCasesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VerifyTestCasesPageTest {
    WebDriver driver;


    @Test(testName = "Verify Test Cases Page")
    public void caseVerifyTestCasesPage(){
        new HomePage(driver).checkSliderInHomePageIsVisible().clickOnTestcasesLink();

        new TestCasesPage(driver).testCaseHeaderIsVisiable();
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
