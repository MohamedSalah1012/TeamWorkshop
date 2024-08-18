package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyCartCases {
    WebDriver driver;
    String baseUrl ="https://automationexercise.com/";

    @Test(testName = "Verify adding products in cart")
    public void addProductInCart(){

        new HomePage(driver)
                .checkSliderInHomePageIsVisible()
                .clickOnTheProductsLink()
                .directClickAddProductToCart(1)
                .clickOnContinueShopping()
                .directClickAddProductToCart(2)
                .clickOnViewCart()
                .getItemDesciptionByItemOrder(1,"Blue Top")
                .getItemPriceByItemOrder(1,"Rs. 500")
                .getItemQuantityByItemOrder(1,"1")
                .getItemTotalPriceByItemOrder(1,"Rs. 500")
                .getItemDesciptionByItemOrder(2,"Men Tshirt")
                .getItemPriceByItemOrder(2,"Rs. 400")
                .getItemQuantityByItemOrder(2,"1")
                .getItemTotalPriceByItemOrder(2,"Rs. 400");
    }

    @Test(testName = "Verify product quantity in cart")
    public void verifyProductQuantity(){

        new HomePage(driver)
                .checkSliderInHomePageIsVisible()
                .clickOnviewProductButton(1)
                .changeProductQuantity("4")
                .clickOnAddToCart()
                .clickOnviewCart()
                .getItemQuantityByItemOrder(1,"4");

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
