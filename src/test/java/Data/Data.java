package Data;

import Models.ClientDTO;
import utils.DataRandom;

import java.io.IOException;

public class Data {


    public ClientDTO createTrainer() throws IOException {
        DataRandom data = new DataRandom();
        String name = "carlos";
        String lastname = "garatea";
        String emailtrainer = data.generateRandomEmail();

        return new ClientDTO(name,lastname,emailtrainer);
    }
}
