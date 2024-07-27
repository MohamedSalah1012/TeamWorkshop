package Pages;
import Bots.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {


    private  WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

                  ////////// Locators /////////

    By  enterAccountInfoLabel = By.xpath("//b[contains(text(),'Enter Account Information')]");

    By passwordField = By.xpath("//input[@id='password']");

    By newsLetterCheckbox = By.xpath("//input[@id='newsletter']");

    By receiveSpecialOfferCheckbox = By.xpath("//input[@id='optin']");
    private By genderRadioBtn(String gender){
        return  By.xpath("//input[@type='radio' and @value='"+ gender +"']");
    }



                    ///////// Methods /////////

    public SignUpPage signUpFormLabelIsVisible(){
        ActionBot.isVisible(driver , enterAccountInfoLabel);
        return new SignUpPage(driver);
    }

    public SignUpPage selectGender(String gender){
        ActionBot.clicking(driver , genderRadioBtn(gender));
        return new SignUpPage(driver);
    }

    public SignUpPage enterPassoword(String password){
        ActionBot.enterText(driver ,passwordField, password);
        return new SignUpPage(driver);
    }

    public SignUpPage checkNewsLetterCheckBox(){
        ActionBot.clicking(driver,newsLetterCheckbox);
        return new SignUpPage(driver);
    }
    public SignUpPage checkReceiveSpecialOfferCheckBox(){
        ActionBot.clicking(driver,receiveSpecialOfferCheckbox);
        return new SignUpPage(driver);
    }
}
