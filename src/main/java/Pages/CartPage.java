package Pages;
import Bots.ActionBot;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.List;
public class CartPage {
    private static WebDriver driver;
    public CartPage(WebDriver driver){
        this.driver = driver;
    }


                                    ///////////// Locators ///////////////
    private final By shoppingCart        = By.xpath("//li[text() = 'Shopping Cart']");
    private final By checkOutButton      = By.xpath("//a[text()='Proceed To Checkout']");
    private final By tableElements       = By.xpath("//tbody/tr");


    //checkoutPopup
    private final By checkoutHeader      = By.xpath("//div//h4[text()='Checkout']");
    private final By registerOrLogin     = By.xpath("//a/u[contains(text() , 'Register / Login')]");
    private final By continueToCart      = By.xpath("//div//button[text()='Continue On Cart']");
    private final By addressDetailsHeader = By.xpath("//h2[text()='Address Details']");
    private final By reviewYourOrderHeader = By.xpath("//h2[text()='Review Your Order']");

    private By productDescription(int productOrder){
        return By.xpath("//tr[@id='product-"+productOrder+"']/td/h4");
    }
    //product price by product number (order) in table
    private By productPrice(int productOrder){
        return By.xpath("//tr[@id='product-"+productOrder+"']/td[@class='cart_price']/p");
    }
    //product quantity by product number (order) in table
    private By productQantity(int productOrder){
        return By.xpath("//tr[@id='product-"+productOrder+"']/td[@class='cart_quantity']/button");
    }
    //product Total price by product number (order) in table
    private By productTotalPrice(int productOrder){
        return By.xpath("//tr[@id='product-"+productOrder+"']/td[@class='cart_total']/p");
    }
    //product delete button by product number (order) in table
    private By deleteProduct(int productOrder){
        return By.xpath("//tr[@id='product-"+productOrder+"']//td//a[@class='cart_quantity_delete']");
    }
                                            //////////// Validations //////////////////

    public CartPage verifyAddressDetailsHeader(){
        ActionBot.isVisible(driver , addressDetailsHeader);
        return this;
    }

    public CartPage verifyReviewYourOrderHeader(){
        ActionBot.isVisible(driver , reviewYourOrderHeader);
        return this;
    }

    public CartPage verifyShoppingCartText(){
        ActionBot.isVisible(driver,shoppingCart);
        return this;
    }

                                            //////////// Methods //////////////////
    public int getProductNumberinCart(){
        List<WebElement> cartItems = driver.findElements(tableElements);
        return cartItems.size();
    }
    public CartPage getItemDesciptionByItemOrder(int itemOrder,String expectedName){
        String actualName   = driver.findElement(productDescription(itemOrder)).getText();
       Assert.assertEquals(actualName,expectedName,"actual item name added from products page is not equal to expected item name into the cart");
       return this;
    }
    public CartPage getItemPriceByItemOrder(int itemOrder,String expectedPrice){
     String actualPrice    = driver.findElement(productPrice(itemOrder)).getText();
     Assert.assertEquals(actualPrice,expectedPrice,"actual item price added from products is not equal to expected item into the cart");
     return this;
    }
    public CartPage getItemQuantityByItemOrder(int itemOrder,String expectedQuantity){

        String actualQuantity  = driver.findElement(productQantity(itemOrder)).getText();
        Assert.assertEquals(actualQuantity,expectedQuantity,"actual item quantity added is not equal expected item quantity");
        return this;
    }
    public CartPage getItemTotalPriceByItemOrder(int itemOrder,String expectedTotalPrice){
       String actualTotalPrice = driver.findElement(productTotalPrice(itemOrder)).getText();
       Assert.assertEquals(actualTotalPrice,expectedTotalPrice,"actual item total price added is not equal expected item total price");
       return this;
    }
    public CartPage deleteItemByOrder(int itemOrder){
        ActionBot.clicking(driver,deleteProduct(itemOrder));
        return this;
    }
    public CartPage proceedToCheckoutWithoutLoggedInUser(){
        ActionBot.clicking(driver,checkOutButton);
        return this;
    }

    public LoginPage clickOnRegisterLink(){
        ActionBot.clicking(driver ,registerOrLogin );
        return new LoginPage(driver);
    }
}
