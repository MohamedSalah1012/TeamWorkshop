package Pages;

import Bots.ActionBot;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
    private final WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }


    /////// Locators ////////



    private final By productName      =   By.xpath("//h2[text()='Blue Top']");
    private final By categoryName      =   By.xpath("//p[text()='Category: Women > Tops']");



    ///////// Validations ///////



    @Description("check that Product name  is displayed ")
    public ProductDetailsPage productNameIsVisible(){
        ActionBot.isVisible(driver, productName);
        return this;
    }

    @Description("check that Category name is displayed ")
    public ProductDetailsPage categoryNameIsVisible(){
        ActionBot.isVisible(driver, categoryName);
        return this;
    }
}
