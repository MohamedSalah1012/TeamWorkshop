package Tests;
import Bots.ActionBot;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
public class SearchProduct {

    WebDriver driver;
    String baseUrl ="https://automationexercise.com/",
           targetedProduct = "Blue Top";



    @Test(testName = "search product")
    public void search_For_product(){
        new HomePage(driver)
                .silderInHomePageIsVisible()
                .clickTheProductsLink();
        new ProductsPage(driver)
                .allProdcutsTextIsVisible()
                .allProdcutsAreaIsVisible()
                .searchForProduct(targetedProduct);
        new SearchResultPage(driver)
                .searchedProductsTextIsVisible();
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
