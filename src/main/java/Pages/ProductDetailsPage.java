package Pages;

import Bots.Bot;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage {
    private final WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }


                                     /////// Locators ////////



    private final By productName       =  By.xpath("//h2[text()='Blue Top']");
    private final By categoryName      =  By.xpath("//p[text()='Category: Women > Tops']");
    private final By quantity          =  By.xpath("//input[@id='quantity']");
    private final By addToCartButton   =  By.xpath("//button[@type='button']");
    //AddedPobup
    private final By viewCartButton    =  By.xpath("//u[text()='View Cart']");
    private final By continueShopping  =  By.xpath("//button[text()='Continue Shopping']");
                                    ///////// Validations ///////



    @Description("check that Product name  is displayed ")
    public ProductDetailsPage productNameIsVisible(){
        Bot.isVisible(driver, productName);
        return this;
    }

    @Description("check that Category name is displayed ")
    public ProductDetailsPage categoryNameIsVisible(){
        Bot.isVisible(driver, categoryName);
        return this;
    }

    @Description(" Change quantity of the product")
    public ProductDetailsPage changeProductQuantity(String productQuantity){
       WebElement productQuantityElement =  driver.findElement(quantity);
        productQuantityElement.clear();
        productQuantityElement.sendKeys(productQuantity);
       return new ProductDetailsPage(driver);
    }


    public ProductDetailsPage clickOnAddToCart(){
        Bot.clicking(driver,addToCartButton);
        return new ProductDetailsPage(driver);
    }

    public ProductDetailsPage clickOnContinueShopping(){
        Bot.clicking(driver,continueShopping);
        return new ProductDetailsPage(driver);
    }

    public CartPage clickOnviewCart(){
        Bot.clicking(driver,viewCartButton);
        return new CartPage(driver);
    }

}
