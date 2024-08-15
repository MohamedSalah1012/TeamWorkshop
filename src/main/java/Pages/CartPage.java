package Pages;

import Bots.ActionBot;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
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
    private final By registerOrLogin     = By.xpath("//div//p/a[@href='/login']");
    private final By continueToCart      = By.xpath("//div//button[text()='Continue On Cart']");

    //product Description by product number (order) in table
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

    //////////// Methods //////////////////


    public CartPage verfyShoppingCartText(){
        ActionBot.isVisible(driver,shoppingCart);
        return this;
    }

    public int getProductNumberinCart(){
        List<WebElement> cartItems = driver.findElements(tableElements);
        return cartItems.size();
    }

    public String getItemDesciptionByItemOrder(int itemOrder){
        WebElement item = driver.findElement(productDescription(itemOrder));
        return item.getText();
    }

    public String getItemPriceByItemOrder(int itemOrder){
        WebElement item = driver.findElement(productPrice(itemOrder));
        return item.getText();
    }

    public String getItemQuantityByItemOrder(int itemOrder){
        WebElement item = driver.findElement(productQantity(itemOrder));
        return item.getText();
    }

    public String getItemTotalPriceByItemOrder(int itemOrder){
        WebElement item = driver.findElement(productTotalPrice(itemOrder));
        return item.getText();
    }

    public CartPage deleteItemByOrder(int itemOrder){
        ActionBot.clicking(driver,deleteProduct(itemOrder));
        return this;
    }

    public CartPage proceedToCheckoutWithoutLoggedInUser(){
        ActionBot.clicking(driver,checkOutButton);
        return this;
    }



}
