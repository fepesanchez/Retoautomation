package utils;
import java.util.Random;
public class DataRandom {
    public String generateRandomEmail(){
        String numbers = "123456789";
        StringBuilder randomNumbers = new StringBuilder(1000);
        for(int i=0; i<5;i++){
            int ranfomIndex= (int)(Math.random()*numbers.length());
            randomNumbers.append(numbers.charAt(ranfomIndex));
        }
        String emailPrefix = "trainer"+ randomNumbers+ "@Gmail.com";
        return emailPrefix;
    }
}
