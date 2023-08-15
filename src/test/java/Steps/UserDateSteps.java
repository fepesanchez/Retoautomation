package Steps;

import Data.Data;
import Driver.Hook;
import Models.ClientDTO;
import Models.EnumData;
import Objetc.InitPage;
import Objetc.Login;
import Objetc.TrainerPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.elasticsearch.core.Map;
import java.util.HashMap;
import java.io.IOException;
import java.util.HashMap;

public class UserDateSteps {
    Login login = new Login(Hook.driver);
    InitPage initpage = new InitPage(Hook.driver);
    TrainerPage trainerpage = new TrainerPage(Hook.driver);
    Data data = new Data();


    public UserDateSteps() throws IOException {
    }

    @When("i complete the data")
    public void iCompleteTheData() throws IOException, InterruptedException {
        data.createTrainer();
        trainerpage.typename(ClientDTO.getname());
        trainerpage.typeLastName(ClientDTO.getLastname());
        trainerpage.typeEmailTrainer(ClientDTO.getEmailtrainer());
        trainerpage.selectOptionRandom(EnumData.paisResidencia.getValor());
        trainerpage.selectOptionRandom(EnumData.zonaHoraria.getValor());
        trainerpage.typeWorksHours();
        trainerpage.selectOptionRandom(EnumData.paisProcedencia.getValor());
        trainerpage.selectOptionRandom(EnumData.teamLeader.getValor());
        trainerpage.selectOptionRandom(EnumData.lenguajes.getValor());
        trainerpage.selectOptionRandom(EnumData.trainerRoutes.getValor());

    }

    @And("i click on the button create trainer")
    public void iClickOnTheButtonCreateTrainer() {
        trainerpage.clickBtnCreateClient();
    }
}
