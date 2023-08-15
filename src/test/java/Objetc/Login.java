package Objetc;
import Data.ConfigReader;
import Driver.Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.By.xpath;
import static utils.Log.Log;
import static utils.Log.logInfo;

import java.io.IOException;
public class Login extends Selenium {

    @CacheLookup
    @FindBy(id = "mat-input-0")
    WebElement inputemail;

    @CacheLookup
    @FindBy(id = "mat-input-1")
    WebElement inputpassword;

    @CacheLookup
    @FindBy(xpath = "(//span[contains(@class,'mat-mdc-button-touch-target')])[2]")
    WebElement btnLogin;


    public Login(WebDriver driver) throws IOException {
        super(driver);
    }

    public void singin() throws IOException{
        ConfigReader data = new ConfigReader();
        logInfo("Login page" + data.getUrl());
        navigateTo(data.getUrl());
    }

    public void typeEmail(String email){
        logInfo("writing the email "+email );
        sendKeys(inputemail,email);
    }

    public void typePassword(String password){
        logInfo("Writing the password "+ password);
        sendKeys(inputpassword,password);
    }

    public void clickLoginButton(){
        clickForce(btnLogin);
    }
}
