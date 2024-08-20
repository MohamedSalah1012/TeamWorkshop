package Pages;
import Bots.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {

                                    //////// Constructor /////////
    private  WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

                                    ////////// Locators /////////

    private By enterAccountInfoLabel       = By.xpath("//b[contains(text(),'Enter Account Information')]");
    private By passwordField                = By.xpath("//input[@id='password']");
    private By newsLetterCheckbox           = By.xpath("//input[@id='newsletter']");
    private By receiveSpecialOfferCheckbox  = By.xpath("//input[@id='optin']");
    private By firstNameField               = By.xpath("//input[@id='first_name']");
    private By lastName                     = By.xpath("//input[@id='last_name']");
    private By companyField                 = By.xpath("//input[@id='company']");
    private By address1                     = By.xpath("//input[@id='address1']");
    private By countryDropDownMenu          = By.xpath("//select[@id='country']");
    private By stateField                   = By.xpath("//input[@id='state']");
    private By cityField                    = By.xpath("//input[@id='city']");
    private By zipcodeField                 = By.xpath("//input[@id='zipcode']");
    private By mobileNumberField            = By.xpath("//input[@id='mobile_number']");
    private By createAccountButton          = By.xpath("//button[@type='submit' and @data-qa='create-account']");
    private By title(String titleGender){
        return  By.xpath("//input[@type='radio' and @value='"+ titleGender +"']");
    }


                                    ///////// Validations /////////


    public SignUpPage signUpFormLabel_IsVisible(){
        ActionBot.isVisible(driver , enterAccountInfoLabel);
        return this;
    }


                                    ///////// Methods ////////////



    public AccountCreatedPage signUpNewAccount(String titleGender, String password, String fname, String lname, String company , String address, String country, String state , String city , String zipcode, String mobilenumber){
        ActionBot.clicking(driver , title(titleGender));
        ActionBot.enterText(driver ,passwordField, password);
        ActionBot.clicking(driver,newsLetterCheckbox);
        ActionBot.clicking(driver,receiveSpecialOfferCheckbox);
        ActionBot.enterText(driver,firstNameField,fname);
        ActionBot.enterText(driver,lastName , lname );
        ActionBot.enterText(driver,companyField , company);
        ActionBot.enterText(driver,address1 , address);
        ActionBot.findCountryDropdownList( driver , countryDropDownMenu).selectByIndex(1);
        ActionBot.enterText(driver ,stateField ,state);
        ActionBot.enterText(driver , cityField , city);
        ActionBot.enterText(driver , zipcodeField , zipcode);
        ActionBot.enterText(driver , mobileNumberField ,mobilenumber);
        ActionBot.clicking(driver , createAccountButton );
        return new AccountCreatedPage(driver);
    }


/*    @Description("Find the country dropdown list ")
    private Select findCountryDropdownElement() {
        return new Select(driver.findElement(countryDropDownMenu));
    }

    @Description(" Select option from dropdown list")
    public SignUpPage select_Country_From_DropDownList(String option) {
        findCountryDropdownElement().selectByVisibleText(option);
        return this;
    }*/



}
