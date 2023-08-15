package Objetc;
import Data.DataTrainer;
import Driver.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrainerPage extends Selenium {
    @CacheLookup
    @FindBy(xpath = "//input[contains(@class, 'mat-mdc-input-element') and contains(@class, 'ng-invalid') and @ng-reflect-name='name']")
    WebElement inputName;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@class, 'mat-mdc-input-element') and contains(@class, 'ng-invalid') and @ng-reflect-name='surname']")
    WebElement inputLastname;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@class, 'mat-mdc-input-element') and contains(@class, 'ng-invalid') and @ng-reflect-name='email']")
    WebElement inputEmailTrainer;

    @CacheLookup
    @FindBy(xpath = "(//span[contains(.,'Crear trainer')])[2]")
    WebElement btnCreateClient;

    @CacheLookup
    @FindBy(xpath = "(//input[@type='email'])[1]")
    WebElement inputEmailSearch;

    @CacheLookup
    @FindBy(xpath = "(//div[contains(.,'carlos garatea')])[3]")
    WebElement txtNameTrainer;

    public TrainerPage(WebDriver driver) throws IOException {
        super(driver);
    }


    public void typename(String name){
        sendKeys(inputName,name);
    }

    public void typeLastName(String lastname){
        sendKeys(inputLastname,lastname);
    }

    public void typeEmailTrainer(String emailtrainer){
        sendKeys(inputEmailTrainer,emailtrainer);
    }

    public void typeWorksHours (){
        WebElement time1 = findElement(By.xpath("(//input[contains(@type,'time')])[1]"));
        sendKeys(time1,"8:00am");
        WebElement time2 = findElement(By.xpath("(//input[contains(@type,'time')])[2]"));
        sendKeys(time2,"12:00pm");
    }

    public void selectOptionRandom(String option) throws InterruptedException {
        WebElement optionList = findElement(By.xpath("(//mat-label[contains(.,'" + option + "')])[11]"));
        click(optionList);
        List<WebElement> elements = findElements(By.xpath("//span[@class='mdc-list-item__primary-text'][contains(.,'')]"));

        String value = DataTrainer.getRandomText(elements);
        WebElement optionSelectList = findElement(By.xpath("//span[@class='mdc-list-item__primary-text'][contains(.,'" + value + "')]"));


        if (option.equals("Rutas del trainer") || option.equals("Idiomas")) {
            Thread.sleep(1000);
            for (int i = 0; i < 2; i++) {
                List<WebElement> innerElements = findElements(By.xpath("//span[@class='mdc-list-item__primary-text'][contains(.,'')]"));
                value = DataTrainer.getRandomText(innerElements);
                WebElement innerOptionSelectList = findElement(By.xpath("//span[@class='mdc-list-item__primary-text'][contains(.,'" + value + "')]"));
                Thread.sleep(1000);

                clickForce(innerOptionSelectList);
                Thread.sleep(1000);
            }
            keyTab();
        } else {
            clickForce(optionSelectList);
            Thread.sleep(1000);
            keyTab();
        }
    }

    public void clickBtnCreateClient(){
        click(btnCreateClient);
    }

    public void searchEmailTrainer(String email){
        sendKeys(inputEmailSearch,email);
    }

    public void verifyNameTrainer(){
        assertEquals("carlos garatea",getText(txtNameTrainer),"Trainer name does not match");
    }

}
