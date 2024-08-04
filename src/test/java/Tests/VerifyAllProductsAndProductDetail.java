package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class VerifyAllProductsAndProductDetail {
    WebDriver driver;
    ChromeOptions chromeOptions;
    String baseUrl ="https://automationexercise.com/" ;


    @Test(testName = "Verify All Products and product detail page")
    public void productDetails(){
        new HomePage(driver)
                .silderInHomePageIsVisible()
                .clickOnTheProductsLink();

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
