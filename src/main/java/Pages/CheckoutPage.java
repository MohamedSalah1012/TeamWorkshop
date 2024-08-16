package Pages;

import Bots.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    ////////// Locators ////////////

    private By checkoutText              = By.xpath("//li[text()='Checkout']");
    private By itemsTableelements        = By.xpath("//tbody/tr");
    private By addCommentTextArea        = By.xpath("//textarea[@class='form-control']");
    private By placeOrder                = By.xpath("//a[text()='Place Order']");

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

    public PaymentPage clickOnPlaceOrder(){
        ActionBot.clicking(driver, placeOrder);
        return new PaymentPage(driver);
    }

}
