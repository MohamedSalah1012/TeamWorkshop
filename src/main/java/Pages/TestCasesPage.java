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

    By homePage = By.xpath("//li/a[@href='/']");
    By testCaseHeader = By.xpath("//span[contains(text(), 'Test')]");
    By belowIsTheListHeader = By.xpath("//span[contains(text(), 'Below is the list of ')]");
    By testCaseTab = By.xpath("//a[contains(text(),'Test Cases')]");

    public void testCaseHeaderIsVisiable(){
        ActionBot.isVisible(driver,testCaseHeader);
    }

    public Boolean isTestCaseHeaderVisiable(){
        WebElement testCase = driver.findElement(testCaseHeader);
        return testCase.isDisplayed();
    }

    public HomePage goToHomePage(){
        ActionBot.clicking(driver,homePage);
        return new HomePage(driver);
    }

    public TestCasesPage goToTestCasesPage(){
        ActionBot.clicking(driver,testCaseTab);
        return this;
    }

}
