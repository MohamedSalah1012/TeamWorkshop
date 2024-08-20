package Pages;

import Bots.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AfterDeleteAccountPage {
    private final WebDriver driver;

    public AfterDeleteAccountPage(WebDriver driver) {
        this.driver = driver;
    }



                                    /////////// Locators //////////
    private final By accountDeletedHeader       = By.xpath("//h2[@data-qa='account-deleted']/b");
    private final By continueButton             = By.xpath("//a[@href='/' and @data-qa=\"continue-button\"]");


                                    /////////// Validations //////////

    public AfterDeleteAccountPage deletedAccountTextIsDisplayed(){
        ActionBot.isVisible(driver , accountDeletedHeader);
        return this;
    }



    public HomePage clickOnContinueButton(){
        ActionBot.clicking(driver , continueButton);
        return new HomePage(driver);
    }

}
