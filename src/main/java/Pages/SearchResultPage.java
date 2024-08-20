package Pages;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {

    private WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }



    private final By searchedProductsText =   By.xpath("//h2[contains(text(),'Searched Products')]");




    @Description(" check that the text is displayed after the search ")
    public SearchResultPage searchedProductsHeaderIsVisible(){
        driver.findElement(searchedProductsText).isDisplayed();
        return this;
    }
}
