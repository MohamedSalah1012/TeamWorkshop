package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
    private WebDriver driver;

    public PaymentPage(WebDriver driver){
        this.driver = driver;
    }

    ////////// Locators /////////

    private By payment              = By.xpath("//li[text()='Payment']") ;
    private By paymentHeader        = By.xpath("//h2[text()='Payment']");
    //payment information
    private By nameOnCard           = By.xpath("//input[@name='name_on_card']");
    private By carNumber            = By.xpath("//input[@name='card_number']");
    private By cvc                  = By.xpath("//input[@name='cvc']");
    private By expiryMonth          = By.xpath("//input[@name='expiry_month']");
    private By expiryYear           = By.xpath("//input[@name='expiry_year']");

    private By payAndConfirmButton  = By.xpath("//button[@id='submit']");


    ////////// Methods //////////



}
