package Pages;

import Bots.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCasesPage {
    private final  WebDriver driver;

    public TestCasesPage(WebDriver driver){
         this.driver = driver;
    }

    /////////// Locators //////////

    By testCaseHeader = By.xpath("//b//span[contains(text(), 'Test')]");

    /////////// Methods //////////

    public void testCaseHeaderIsVisiable(){
        ActionBot.isVisible(driver,testCaseHeader);
    }

}
