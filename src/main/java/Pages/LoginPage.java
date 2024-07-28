package Pages;
import Bots.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


                                         //////// Locators////////

    private final By newUserSignUpHeader    = By.xpath("//h2[text()='New User Signup!']");
    private final By userNameForNewUser     = By.xpath("//input[@type='text']");
    private final By emailForNewUSer        = By.xpath("(//input[@type = 'email' and @name='email'])[2]");
    private final By signUpButton           = By.xpath("/html/body/section/div/div/div[3]/div/form/button");




    public LoginPage newUserSignUpHeader_Is_Visible(){
        ActionBot.isVisible(driver , newUserSignUpHeader);
        return this;
    }

                                        ///////// Methods ////////

    public SignUpPage fillUserSignUpFrom(String username , String email){
        ActionBot.enterText(driver , userNameForNewUser , username);
        ActionBot.enterText( driver , emailForNewUSer ,email);
        ActionBot.clicking(driver , signUpButton);
        return new SignUpPage(driver);
    }
}
