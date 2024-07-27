package Pages;

import Bots.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeletedAccount {
    private final WebDriver driver;

    public DeletedAccount(WebDriver driver) {
        this.driver = driver;
    }

    By accountDeletedHeader = By.xpath("//h2[@data-qa='account-deleted']/b");




    public DeletedAccount deletedAccountTextIsDisplayed(){
        ActionBot.isVisible(driver , accountDeletedHeader);
        return new DeletedAccount(driver);
    }

}
