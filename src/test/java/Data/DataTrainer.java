package Data;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class DataTrainer {

    public static String getRandomText(List<WebElement> elements) {
        List<String> texts = new ArrayList<>();

        for (WebElement element : elements) {
            String text = element.getText();
            texts.add(text);
        }

        Random random = new Random();
        int randomIndex = random.nextInt(texts.size());
        String randomText = texts.get(randomIndex);

        return randomText;
    }

    public static List<String> getHoursStartAndEnd(){
        int minHour = 6;
        int maxHour = 18;
        int startHour, endHour;
        Random random = new Random();

        do {
            startHour = random.nextInt(maxHour - minHour + 1) + minHour;
            endHour = startHour + 8;
        }while (endHour>startHour);

        int minutes = random.nextInt(60);

        startHour = startHour > 12? startHour -12: startHour;
        endHour = endHour > 12? endHour -12 :endHour;

        String startTime = String.format("%02d", startHour) + String.format("%02d", minutes) + "am";
        String endTime = String.format("%02d", endHour) + String.format("%02d", minutes) + "pm";

        if (startHour >= 12) {
            startTime = startTime.replace("am", "pm");
        }

        List<String> result = new ArrayList<>();
        result.add(startTime);
        result.add(endTime);
        return result;
    }

}
