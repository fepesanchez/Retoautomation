package Steps;
import Data.Data;
import Driver.Hook;
import Models.ClientDTO;
import Objetc.InitPage;
import Objetc.Login;
import Objetc.TrainerPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import io.cucumber.java.en.Then;



public class InitPageSteps {

    InitPage initpage = new InitPage(Hook.driver);
    TrainerPage trainerPage = new TrainerPage(Hook.driver);


    public InitPageSteps() throws IOException {
    }

    @Then("i can see init page")
    public void iCanSeeInitPage() {
        initpage.verifyInitPageText();
    }

    @Given("i click on the button list of trainers")
    public void iClickOnTheButtonListOfTrainers() {
        initpage.clickListOfTrainers();
    }

    @And("i click on the button Add trainer")
    public void iClickOnTheButtonAddTrainer() {
        initpage.clickAddTrainer();
    }


    @Then("i can see the client created")
    public void iCanSeeTheClientCreated() {
        trainerPage.searchEmailTrainer(ClientDTO.getEmailtrainer());
        trainerPage.verifyNameTrainer();
    }


}
