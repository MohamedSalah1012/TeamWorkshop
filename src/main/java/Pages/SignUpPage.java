package Pages;
import Bots.ActionBot;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {

                                    //////// Constructor /////////
    private  WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

                                    ////////// Locators /////////

    private By  enterAccountInfoLabel       = By.xpath("//b[contains(text(),'Enter Account Information')]");
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





    public SignUpPage selectGender(String titleGender){
        ActionBot.clicking(driver , title(titleGender));
        return this;
    }

    public SignUpPage enterPassword(String password){
        ActionBot.enterText(driver ,passwordField, password);
        return this;
    }

    public SignUpPage checkNewsLetterCheckBox(){
        ActionBot.clicking(driver,newsLetterCheckbox);
        return this;
    }
    public SignUpPage check_Receive_Special_Offer_CheckBox(){
        ActionBot.clicking(driver,receiveSpecialOfferCheckbox);
        return this;
    }

    public SignUpPage enterFirstName(String fname){
        ActionBot.enterText(driver,firstNameField,fname);
        return this;
    }

    public SignUpPage enterLastName(String lname){
        ActionBot.enterText(driver,lastName , lname);
        return this;
    }

    public SignUpPage enterCompany(String company){
        ActionBot.enterText(driver,companyField , company);
        return this;
    }

    public SignUpPage enterAddress(String address){
        ActionBot.enterText(driver,address1 , address);
        return this;
    }



    public SignUpPage selectCountry(String option){
        ActionBot.findCountryDropdownList( driver , countryDropDownMenu).selectByVisibleText(option);
        return this;
    }




//    @Description("Find the country dropdown list ")
//    private Select findCountryDropdownElement() {
//        return new Select(driver.findElement(countryDropDownMenu));
//    }
//
//    @Description(" Select option from dropdown list")
//    public SignUpPage select_Country_From_DropDownList(String option) {
//        findCountryDropdownElement().selectByVisibleText(option);
//        return this;
//    }

    public SignUpPage otherfields(String state , String city , String zipcode, String mobilenumber){
        ActionBot.enterText(driver ,stateField ,state);
        ActionBot.enterText(driver , cityField , city);
        ActionBot.enterText(driver , zipcodeField , zipcode);
        ActionBot.enterText(driver , mobileNumberField ,mobilenumber);
        return this;
    }

    public AccountCreatedPage clickCreateAccountButton(){
        ActionBot.clicking(driver , createAccountButton );
        return new AccountCreatedPage(driver);
    }

}
