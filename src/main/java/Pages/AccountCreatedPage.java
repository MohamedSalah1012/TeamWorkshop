package Pages;

import Bots.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage {

    private final WebDriver driver;

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }


    ///////////// Locators //////////


    private final By accountCreatedHeader =By.xpath("//h2[@data-qa='account-created']//b");
    private final By continueButton  =By.xpath("//a[@data-qa='continue-button']");


                        /////////// Methods ////////////
    public AccountCreatedPage accountCreatedHeaderisVisible(){
        ActionBot.isVisible(driver ,accountCreatedHeader);
        return this;
    }

    public HomePage clickContinueButton(){
        ActionBot.clicking(driver ,continueButton);
        return new HomePage(driver);
    }
}
