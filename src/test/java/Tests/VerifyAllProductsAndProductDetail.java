package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class VerifyAllProductsAndProductDetail {
    WebDriver driver;
    String baseUrl ="https://automationexercise.com/" ;


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
