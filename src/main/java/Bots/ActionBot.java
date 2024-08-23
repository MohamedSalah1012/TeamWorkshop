package Bots;
import jdk.jfr.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;


public class ActionBot {

    private static WebDriver driver ;




     static FluentWait wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofMillis(250))
            .ignoring(NoSuchElementException.class)
            .ignoring(NotFoundException.class)
            .ignoring(ElementNotInteractableException.class)
            .ignoring(AssertionError.class)
            .ignoring(StaleElementReferenceException.class);

    public static void clicking(WebDriver driver , By locator){
            wait.until(f -> {
            driver.findElement(locator).click();
            return true;
        });
    }



    public static void enterText(WebDriver driver , By locator, String text){
            wait.until(f -> {
            driver.findElement(locator).sendKeys(text);
            return true;
        });
    }

    public static void isVisible(WebDriver driver , By locator){
            wait.until(f -> {
            driver.findElement(locator).isDisplayed();
            return true;
        });
    }


    @Description("Find the dropdown list ")
    public static Select findCountryDropdownList( WebDriver driver ,By locator ) {
        wait.until(f -> {
            driver.findElement(locator).click();
            return true;
        });
        return new Select(driver.findElement(locator));
    }

    public static void acceptAlert(WebDriver driver){
        wait.until(f -> {
            driver.switchTo().alert().accept();
            return true;
        });
    }


}
