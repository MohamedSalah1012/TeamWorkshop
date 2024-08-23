package Pages;
import Bots.Bot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        Bot.isVisible(driver , enterAccountInfoLabel);
        return this;
    }


                                    ///////// Methods ////////////



    public AfterCreateAccountPage signUpNewAccount(String titleGender, String password, String fname, String lname, String company , String address, String country, String state , String city , String zipcode, String mobilenumber){
        Bot.clicking(driver , title(titleGender));
        Bot.enterText(driver ,passwordField, password);
        Bot.clicking(driver,newsLetterCheckbox);
        Bot.clicking(driver,receiveSpecialOfferCheckbox);
        Bot.enterText(driver,firstNameField,fname);
        Bot.enterText(driver,lastName , lname );
        Bot.enterText(driver,companyField , company);
        Bot.enterText(driver,address1 , address);
        Bot.findCountryDropdownList( driver , countryDropDownMenu).selectByIndex(1);
        Bot.enterText(driver ,stateField ,state);
        Bot.enterText(driver , cityField , city);
        Bot.enterText(driver , zipcodeField , zipcode);
        Bot.enterText(driver , mobileNumberField ,mobilenumber);
        Bot.clicking(driver , createAccountButton );
        return new AfterCreateAccountPage(driver);
    }


// @Description("Find the country dropdown list ")
//    private Select findCountryDropdownElement() {
//        return new Select(driver.findElement(countryDropDownMenu));
//    }
//
//    @Description(" Select option from dropdown list")
//    public SignUpPage select_Country_From_DropDownList(String option) {
//        findCountryDropdownElement().selectByVisibleText(option);
//        return this;
//    }*/



}
