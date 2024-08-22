package Tests.Random;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
public class SearchProductTest {

    WebDriver driver;
    ChromeOptions chromeOptions;
    String    targetedProduct = "Blue Top";



    @Test(testName = "search product")
    public void search_For_product(){
        new HomePage(driver)
                .checkSliderInHomePageIsVisible()
                .clickOnTheProductsLink();
        new ProductsPage(driver)
                .allProdcutsTextIsVisible()
                .allProdcutsAreaIsVisible()
                .searchForProduct(targetedProduct);
        new SearchResultPage(driver)
                .searchedProductsHeaderIsVisible();
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
