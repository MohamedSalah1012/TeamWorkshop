package Pages;

import Bots.ActionBot;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
    private WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

                                /////////// Locators //////////
    private final By getInTouchHeader =     By.xpath("//h2[contains(text(),'Get In Touch')]");

    private final By nameField        =     By.xpath("//input[@type ='text' and @data-qa=\"name\"]");

    private final By emailField       =     By.xpath("//input[@type ='email' and @data-qa='email']");

    private final By messageBox      =      By.xpath("//textarea[@id=\"message\"]");
    private final By subjectField     =     By.xpath("//input[@type ='text' and @data-qa='subject']");

    private final By uploadButton     =     By.xpath("//input[@type ='file' and @name=\"upload_file\"]");

    private final By submitButton     =     By.xpath("//input[@type ='submit' and @data-qa=\"submit-button\"]");

    private final By successMessage   =     By.xpath("//div[@class=\"status alert alert-success\" and contains(text() , 'Success! Your details have been submitted successfully.')]");

    @Description("This button will be visible only after sending the inquiry successfully")
    private final By homePageButton   =     By.xpath("//div[@id='form-section']//a[@href='/']");




                            /////////// Validations //////////

    public  ContactUsPage getInTouchHeaderIsVisible(){
        ActionBot.isVisible(driver,getInTouchHeader);
        return this;
    }

    public  ContactUsPage successMessageIsVisible(){
        ActionBot.isVisible(driver,successMessage);
        return this;
    }



                                /////////// Methods //////////
    public ContactUsPage fillContactUsFormAndSubmit(String name, String email, String subject , String message , String file){
        ActionBot.enterText(driver,nameField,name);
        ActionBot.enterText(driver, emailField ,email );
        ActionBot.enterText(driver,  subjectField , subject );
        ActionBot.enterText(driver , messageBox ,message );
        ActionBot.enterText(driver,uploadButton ,file);
        ActionBot.clicking(driver , submitButton);
        ActionBot.acceptAlert(driver);
        return this;
    }


    @Description("By clicking this button, you will be redirected to the home page")
    public HomePage clickOnTheHomePageButton(){
        ActionBot.clicking(driver,homePageButton);
        return new HomePage(driver);
    }

}
