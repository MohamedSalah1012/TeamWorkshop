package Tests;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyCartCases {
    WebDriver driver;
    String baseUrl ="https://automationexercise.com/";

    @Test(testName = "Verify adding products in cart")
    public void addProductInCart(){
        HomePage homePage = new HomePage(driver);
        homePage.checkSliderInHomePageIsVisible();
        homePage.clickOnTheProductsLink();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProducttoCart(1).clickOnContinueShopping();
        productsPage.addProducttoCart(2).clickOnViewCart();

        //Verify that items added
        CartPage cartPage = new CartPage(driver);
        String productAdded = cartPage.getItemDesciptionByItemOrder(1);
        Assert.assertEquals(productAdded, "Blue Top");
        productAdded = cartPage.getItemDesciptionByItemOrder(2);
        Assert.assertEquals(productAdded,"Men Tshirt");

        //Verify items prices
        String productPrice = cartPage.getItemPriceByItemOrder(1);
        Assert.assertEquals(productPrice,"Rs. 500");
        productPrice = cartPage.getItemPriceByItemOrder(2);
        Assert.assertEquals(productPrice,"Rs. 400");

        //Verify items quantity
        String productQuantity = cartPage.getItemQuantityByItemOrder(1);
        Assert.assertEquals(productQuantity,"1");
        productQuantity = cartPage.getItemQuantityByItemOrder(2);
        Assert.assertEquals(productQuantity,"1");

        //Verify total price
        String productTotalPrice = cartPage.getItemTotalPriceByItemOrder(1);
        Assert.assertEquals(productTotalPrice,"Rs. 500");
        productTotalPrice = cartPage.getItemTotalPriceByItemOrder(2);
        Assert.assertEquals(productTotalPrice,"Rs. 400");

    }

    @Test(testName = "Verify product quantity in cart")
    public void verifyProductQuantity(){
        HomePage homePage = new HomePage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.checkSliderInHomePageIsVisible()
            .clickOnviewProductButton(1)
                .changeProductQuantity("4")
                .clickOnAddToCart()
                .clickOnviewCart();
        String quantity = cartPage.getItemQuantityByItemOrder(1);
        Assert.assertEquals(quantity,"4");

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
