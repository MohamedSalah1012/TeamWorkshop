package Pages;
import Bots.Bot;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


                                         //////// Locators////////



    @Description("These locators for the 'Sign Up' section")
    private final By newUserSignUpHeader    = By.xpath("//h2[text()='New User Signup!']");
    private final By userNameForNewUser     = By.xpath("//input[@type='text']");
    private final By emailForNewUSer        = By.xpath("(//input[@type = 'email' and @name='email'])[2]");
    private final By signUpButton           = By.xpath("//button[@type = 'submit' and text()='Signup']");

    @Description("These locators for the 'login' section ")
    private final By loginHeader = By.xpath("//h2[text()='Login to your account']");
    private final By email_ForLogin         = By.xpath("//input[@type=\"email\" and @ data-qa=\"login-email\"]");
    private final By password_ForLogin      = By.xpath("//input[@type='password' and @ data-qa= 'login-password']");
    private final By loginButton            = By.xpath("//button[@type='submit' and @data-qa=\"login-button\"]");
    private final By alertMsg_InvalidLogin = By.xpath("//p[contains(text(),'Your email or password is incorrect!') ]");


                                        ///////// Validations ////////

    public LoginPage newUserSignUpHeader_Is_Visible(){
        Bot.isVisible(driver , newUserSignUpHeader);
        return this;
    }


    public LoginPage loginHeader_Is_Visible(){
        Bot.isVisible(driver , loginHeader);
        return this;
    }

                                        ///////// Methods //////////


    public LoginPage loginWithValidCredentials(String invalidEmail , String InvalidPass){
        Bot.enterText(driver , email_ForLogin , invalidEmail);
        Bot.enterText(driver ,password_ForLogin ,InvalidPass);
        Bot.clicking(driver, loginButton);
        return this;
    }

    public LoginPage checkAlertMessageIsDisplayed(){
        Bot.isVisible(driver , alertMsg_InvalidLogin);
        return this;
    }




    public SignUpPage enterUsernameAndEmailAndClickSignUp(String username , String email){
        Bot.enterText(driver , userNameForNewUser , username);
        Bot.enterText( driver , emailForNewUSer ,email );
        Bot.clicking(driver , signUpButton);
        return new SignUpPage(driver);
    }
}
