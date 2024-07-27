package Pages;

import Bots.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeletedAccountPage {
    private final WebDriver driver;

    public DeletedAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    By accountDeletedHeader = By.xpath("//h2[@data-qa='account-deleted']/b");




    public DeletedAccountPage deletedAccountTextIsDisplayed(){
        ActionBot.isVisible(driver , accountDeletedHeader);
        return new DeletedAccountPage(driver);
    }

}
