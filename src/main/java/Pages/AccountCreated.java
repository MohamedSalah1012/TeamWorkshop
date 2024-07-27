package Pages;

import Bots.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreated {

    private final WebDriver driver;

    public AccountCreated(WebDriver driver) {
        this.driver = driver;
    }


                    ///////////// Locators //////////


    By accountCreatedHeader =By.xpath("//h2[@data-qa='account-created']//b");
    By continueButton  =By.xpath("//a[@data-qa='continue-button']");


                    /////////// Methods ////////////
    public AccountCreated  accountCreatedHeaderisVisible(){
        ActionBot.isVisible(driver ,accountCreatedHeader);
        return new AccountCreated(driver);
    }

    public AccountCreated  clickContinueButton(){
        ActionBot.clicking(driver ,continueButton);
        return new AccountCreated(driver);
    }
}
