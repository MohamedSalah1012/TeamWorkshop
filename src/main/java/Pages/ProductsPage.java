package Pages;

import Bots.ActionBot;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductsPage {
    private  WebDriver driver;
    private  Actions actions;


    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }


    /////// Locators ////////


    private final By allProductsArea      =   By.xpath("//div[@class='features_items']");
    private final By allProductsText      =   By.xpath("//h2[contains(text() , 'All Products')]");
    private final By searchInput          =   By.xpath("//input[@name='search' and @id='search_product']");
    private final By searchButton         =   By.xpath("//button[@id=\"submit_search\"]");
    private final By viewProductButton    =   By.xpath("//li//a[@href='/product_details/1']");
    private final By firstProductinPage   =   By.xpath("(//div[@class='single-products'])[1]");
    private final By secondProductinPage  =   By.xpath("(//div[@class='single-products'])[2]");
    //addedpopup
    private final By addedHeader          =   By.xpath("//div/div[@class='modal-header']//h4[text()='Added!']");
    private final By confirmationMessage  =   By.xpath("//div/div[@class='modal-body']//p[text()='Your product has been added to cart.']");
    private final By viewCartButton       =   By.xpath("//div//u[text()='View Cart']");
    private final By continueShoppingButton = By.xpath("//div//button[text()='Continue Shopping']");
    //find product By product order in page
    private By productByOrderinPage (int productOrder){
        return By.xpath("(//div[@class='single-products'])["+productOrder+"]");
    }
    //add to cart button (after hovering) of product by order in page
    private By addTocartButton(int productOrder){
        return By.xpath("//a[@data-product-id="+productOrder+"]");
    }

    ///////// Validations ///////

    @Description("check that  'All products' text is displayed ")
    public ProductsPage allProdcutsTextIsVisible(){
        ActionBot.isVisible(driver, allProductsText);
        return this;
    }

    @Description("check that   'All products' area is displayed ")
    public ProductsPage allProdcutsAreaIsVisible(){
        ActionBot.isVisible(driver, allProductsArea);
        return this;
    }





    //////// Methods ////////

    @Description(" Enter a product name in the 'search input & click on search button  ")
    public SearchResultPage searchForProduct(String product){
        ActionBot.enterText(driver, searchInput, product);
        ActionBot.clicking(driver, searchButton);
        return new SearchResultPage(driver);
    }

    @Description(" Enter a product name in the 'search input & click on search button  ")
    public ProductDetailsPage clickOnViewProductButton() {
        ActionBot.clicking(driver ,viewProductButton);
        return new ProductDetailsPage(driver);
    }

    @Description(" Add product to cart by hovering over product by product order in page and click continue to shopping ")
    public ProductsPage addProducttoCart(int productOrder){

        actions = new Actions(driver);
        WebElement elementToHover = driver.findElement(productByOrderinPage(productOrder));
        WebElement buttonAfterHover = driver.findElement(addTocartButton(productOrder));
        actions.moveToElement(elementToHover).moveToElement(buttonAfterHover).click().perform();
        return new ProductsPage(driver);
    }


    public ProductsPage clickOnContinueShopping() {
        ActionBot.clicking(driver ,continueShoppingButton);
        return new ProductsPage(driver);
    }

    public CartPage clickOnViewCart() {
        ActionBot.clicking(driver ,viewCartButton);
        return new CartPage(driver);
    }



}
