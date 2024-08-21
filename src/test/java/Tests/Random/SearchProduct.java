package Tests.Random;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
public class SearchProduct {

    WebDriver driver;
    ChromeOptions chromeOptions;
    String baseUrl ="https://automationexercise.com/",
           targetedProduct = "Blue Top";



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
