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

    By testCaseHeader = By.xpath("//span[contains(text(), 'Test')]");
    By belowIsTheListHeader = By.xpath("//span[contains(text(), 'Below is the list of ')]");


    /////////// Methods //////////

    public void testCaseHeaderIsVisiable(){
        ActionBot.isVisible(driver,testCaseHeader);
    }

    public void belowIsTheListHeaderIsVisiable(){ActionBot.isVisible(driver, belowIsTheListHeader);}
    
}
