package Pages;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }



                                ////////// Locators ////////////


    private By placeOrderButton         = By.xpath("//a[@href='/payment' and text()='Place Order']");

    private final By textArea           = By.xpath("//textarea[@class='form-control']");

    private final By cartMenuHeaders(String headerName){
        return By.xpath("//tr[@class=\"cart_menu\"]//td[@class='" + headerName+ "']");
    }



    @Description(" Check that all the headers in the table are displayed ")
    public static List<String> validTableHeaders = Arrays.asList("image", "description", "price", "quantity","total");
    public CheckoutPage checkTableHeadersArePresent(List<String> headerTableElements) {
        for (String headerElement : headerTableElements) {
            if (!driver.findElement(cartMenuHeaders(headerElement)).isDisplayed()) {
                throw new AssertionError(" A Header is missing ");
            }
        }
        return this ;
    }



    public PaymentPage clickOnPlaceOrder(){
       driver.findElement(placeOrderButton).click();
        return new PaymentPage(driver);
    }

    public CheckoutPage typeComment(String comment){
        driver.findElement(textArea).sendKeys(comment);
        return this;
    }

}
