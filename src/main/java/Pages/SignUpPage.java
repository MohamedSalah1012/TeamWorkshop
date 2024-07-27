package Pages;
import Bots.ActionBot;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

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

    By firstNameField = By.xpath("//input[@id='first_name']");
    By lastName = By.xpath("//input[@id='last_name']");
    By companyField = By.xpath("//input[@id='company']");
    By address1 = By.xpath("//input[@id='address1']");
    By countryDropDownMenu = By.xpath("//select[@id='country']");
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

    public SignUpPage enterFirstName(String fname){
        ActionBot.enterText(driver,firstNameField,fname);
        return new SignUpPage(driver);
    }

    public SignUpPage enterLastName(String lname){
        ActionBot.enterText(driver,lastName , lname);
        return new SignUpPage(driver);
    }

    public SignUpPage enterCompany(String company){
        ActionBot.enterText(driver,companyField , company);
        return new SignUpPage(driver);
    }

    public SignUpPage enterAddress(String address1){
        ActionBot.enterText(driver,companyField , address1);
        return new SignUpPage(driver);
    }

    private Select findCountryDropdownElement() {
        return new Select(driver.findElement(countryDropDownMenu));
    }

    @Description(" Select option from dropdown list")
    public SignUpPage select_From_DropDownList(String option) {
        findCountryDropdownElement().selectByVisibleText(option);
        return new SignUpPage(driver);
    }

}
