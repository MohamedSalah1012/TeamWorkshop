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


    By accountCreatedHeader =By.xpath("//h2[@data-qa='account-created']//b");
    By continueButton  =By.xpath("//a[@data-qa='continue-button']");


                    /////////// Methods ////////////
    public AccountCreatedPage accountCreatedHeaderisVisible(){
        ActionBot.isVisible(driver ,accountCreatedHeader);
        return new AccountCreatedPage(driver);
    }

    public AccountCreatedPage clickContinueButton(){
        ActionBot.clicking(driver ,continueButton);
        return new AccountCreatedPage(driver);
    }
}
