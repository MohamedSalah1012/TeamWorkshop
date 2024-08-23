package Pages;

import Bots.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage {
    private final  WebDriver driver;

    public TestCasesPage(WebDriver driver){
         this.driver = driver;
    }

    /////////// Locators //////////

    By testCaseHeader = By.xpath("//b//span[contains(text(), 'Test')]");

    /////////// Methods //////////

    public void testCaseHeaderIsVisiable(){
        Bot.isVisible(driver,testCaseHeader);
    }

}
