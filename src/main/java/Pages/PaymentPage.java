package Pages;

import Bots.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
    private WebDriver driver;

    public PaymentPage(WebDriver driver){
        this.driver = driver;
    }



                                            ////////// Locators /////////

    //payment information
    private By nameOnCard                = By.xpath("//input[@name='name_on_card']");
    private By carNumberInput            = By.xpath("//input[@name='card_number']");
    private By cvcInput                  = By.xpath("//input[@name='cvc']");
    private By expiryMonthInput          = By.xpath("//input[@name='expiry_month']");
    private By expiryYearInput           = By.xpath("//input[@name='expiry_year']");

    private By payAndConfirmOrderButton  = By.xpath("//button[@id='submit']");


                                    ////////// Methods //////////


    public PaymentPage enterYourCredentials(String name , String cardNumber , String cvc , String expiryMonth, String expiryYear) {
        ActionBot.enterText(driver, nameOnCard, name);
        ActionBot.enterText(driver, carNumberInput, cardNumber);
        ActionBot.enterText(driver , cvcInput ,cvc );
        ActionBot.enterText(driver , expiryMonthInput , expiryMonth);
        ActionBot.enterText(driver , expiryYearInput, expiryYear);
        ActionBot.clicking(driver , payAndConfirmOrderButton);
        return this;
    }




}
