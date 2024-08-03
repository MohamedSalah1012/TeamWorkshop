package Pages;

import Bots.ActionBot;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private  WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }


                                    /////// Locators ////////


    private final By allProductsArea      =   By.xpath("//div[@class='features_items']");
    private final By allProductsText      =   By.xpath("//h2[contains(text() , 'All Products')]");
    private final By searchInput          =   By.xpath("//input[@name='search' and @id='search_product']");
    private final By searchButton         =   By.xpath("//button[@id=\"submit_search\"]");


                                ///////// Validations ///////

    @Description("check that  'All products' text is displayed ")
    public ProductsPage allProdcutsTextIsVisible(){
        driver.findElement(allProductsText).isDisplayed();
        return this;
    }

    @Description("check that   'All products' area is displayed ")
    public ProductsPage allProdcutsAreaIsVisible(){
        driver.findElement(allProductsArea).isDisplayed();
        return this;
    }





                                //////// Methods ////////

    @Description(" Enter a product name in the 'search input & click on seach button  ")
    public SearchResultPage searchForProduct(String product){
        driver.findElement(searchInput).sendKeys(product);
        driver.findElement(searchButton).click();
        return new SearchResultPage(driver);
    }


}
