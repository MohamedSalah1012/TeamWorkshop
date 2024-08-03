package Pages;
import Bots.ActionBot;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    private final By signUpButton           = By.xpath("/html/body/section/div/div/div[3]/div/form/button");

    @Description("These locators for the 'login' section ")
    private final By loginHeader = By.xpath("//h2[text()='Login to your account']");
    private final By email_ForLogin         = By.xpath("//input[@type=\"email\" and @ data-qa=\"login-email\"]");
    private final By password_ForLogin      = By.xpath("//input[@type='password' and @ data-qa= 'login-password']");
    private final By loginButton            = By.xpath("//button[@type='submit' and @data-qa=\"login-button\"]");
    private final By alertMsg_InvalidLogin = By.xpath("//p[contains(text(),'Your email or password is incorrect!') ]");


                                        ///////// Validations ////////

    public LoginPage newUserSignUpHeader_Is_Visible(){
        ActionBot.isVisible(driver , newUserSignUpHeader);
        return this;
    }


    public LoginPage loginHeader_Is_Visible(){
        ActionBot.isVisible(driver , loginHeader);
        return this;
    }

                                        ///////// Methods //////////


    public LoginPage loginWithValidCredentials(String invalidEmail , String InvalidPass){
        ActionBot.enterText(driver , email_ForLogin , invalidEmail);
        ActionBot.enterText(driver ,password_ForLogin ,InvalidPass);
        ActionBot.clicking(driver, loginButton);
        return this;
    }

    public LoginPage checkAlertMessageIsDisplayed(){
        ActionBot.isVisible(driver , alertMsg_InvalidLogin);
        return this;
    }




    public SignUpPage enterUsernameAndEmail(String username , String email){
        ActionBot.enterText(driver , userNameForNewUser , username);
        ActionBot.enterText( driver , emailForNewUSer ,email );
        ActionBot.clicking(driver , signUpButton);
        return new SignUpPage(driver);
    }
}
