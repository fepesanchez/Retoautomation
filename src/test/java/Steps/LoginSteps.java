package Steps;
import Data.Data;
import Driver.Hook;
import Models.ClientDTO;
import Data.ConfigReader;
import Objetc.Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class LoginSteps {

    Login login = new Login(Hook.driver);

    ConfigReader data = new ConfigReader();

    public LoginSteps() throws IOException {
    }

    @Given("i am in the home page")
    public void iAmInTheHomePage() throws IOException {
        login.singin();
    }

    @When("i type user and password")
    public void iTypeUserAndPassword() throws IOException {
        login.typeEmail(data.getEmail());
        login.typePassword(data.getPassword());
    }

    @And("i click on the login button")
    public void iClickOnTheLoginButton() {
        login.clickLoginButton();
    }

}
