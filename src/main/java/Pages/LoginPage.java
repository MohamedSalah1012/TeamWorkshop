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

    By newUserSignUpHeader = By.xpath("//h2[text()='New User Signup!']");

    By userNameForNewUser = By.xpath("//input[@type='text']");
    By emailForNewUSer = By.xpath("(//input[@type = 'email' and @name='email'])[2]");

    By signUpButton = By.xpath("/html/body/section/div/div/div[3]/div/form/button");

    ///////// Methods //////

    public LoginPage newUserSignUpHeader_Is_Visible(){
        ActionBot.isVisible(driver , newUserSignUpHeader);
        return new LoginPage(driver);
    }

    public SignUpPage fillUserSignUpFrom(String username , String email){
        ActionBot.enterText(driver , userNameForNewUser , username);
        ActionBot.enterText( driver , emailForNewUSer ,email);
        ActionBot.clicking(driver , signUpButton);
        return new SignUpPage(driver);
    }
}
