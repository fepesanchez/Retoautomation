package Objetc;

import Driver.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class InitPage extends Selenium {
    public InitPage(WebDriver driver) throws IOException {
        super(driver);
    }

    @CacheLookup
    @FindBy(xpath = "//p[@class='text-xl pt-2'][contains(.,'Admin')]")
    WebElement viewInitPage;
    @CacheLookup
    @FindBy(xpath = "//span[@class='mat-mdc-list-item-unscoped-content mdc-list-item__primary-text'][contains(.,'language Listado de trainers')]")
    WebElement btnlistOfTrainers;
    @CacheLookup
    @FindBy(xpath = "//span[contains(.,'Añadir trainer')]")
    WebElement btnAddTrainer;





    public void verifyInitPageText(){
        assertEquals("Admin",getText(viewInitPage),"No coincide el texto del Init page");
    }
    public void clickListOfTrainers (){
        clickForce(btnlistOfTrainers);
    }
    public void clickAddTrainer (){
        clickForce(btnAddTrainer);
    }


}
