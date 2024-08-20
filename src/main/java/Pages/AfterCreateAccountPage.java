package Pages;

import Bots.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AfterCreateAccountPage {

    private final WebDriver driver;

    public AfterCreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }


                                ///////////// Locators //////////


    private final By accountCreatedHeader   =By.xpath("//h2[@data-qa='account-created']//b");
    private final By continueButton         =By.xpath("//a[@data-qa='continue-button']");


                                /////////// Methods ////////////
    public AfterCreateAccountPage accountCreatedHeaderIsVisible(){
        ActionBot.isVisible(driver ,accountCreatedHeader);
        return this;
    }

    public HomePage clickOnContinueButton(){
        ActionBot.clicking(driver ,continueButton);
        return new HomePage(driver);
    }
}