package Tests;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyAllProductsAndProductDetail {
    WebDriver driver;
    String baseUrl ="https://automationexercise.com/";



    @Test(testName = "Verify All Products and product detail page")
    public void productDetails(){
        new HomePage(driver)
                .silderInHomePageIsVisible()
                .clickTheProductsLink();

        new ProductsPage(driver)
                .allProdcutsTextIsVisible()
                .allProdcutsAreaIsVisible()
                .clickOnViewProductButton();

        new ProductDetailsPage(driver)
                .productNameIsVisible()
                .categoryNameIsVisible();
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
