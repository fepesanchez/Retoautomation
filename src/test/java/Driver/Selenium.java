package Driver;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static utils.Log.LogError;
public class Selenium {

    private WebDriver driver = Hook.driver;

    ArrayList<String> tabs;

    public Selenium(WebDriver driver) throws IOException {
        PageFactory.initElements(driver, this);
    }

    public void navigateTo (String url) {
        try {
            driver.get(url);

        } catch (NoSuchElementException | TimeoutException e) {
            LogError(e.getRawMessage());
            Assert.fail("[Selenium] : No se puedo realizar el " +Thread.currentThread().getStackTrace()[1].getMethodName()+ " Para la : "+url +" La clase donde fue llamado es : "+ String.format(("")));


        } catch (Exception e) {
            LogError(e.getMessage());
            Assert.fail("[Selenium] : No se puedo realizar el " +Thread.currentThread().getStackTrace()[1].getMethodName()+ " Para la : "+url +" La clase donde fue llamado es : "+ String.format(("")));

        }
    }

    public WebElement findElement(By element) { return  driver.findElement(element);}

    public List<WebElement> findElements(By element) {
        return driver.findElements(element);
    }
    public void keyTab() {
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
    }
    public void waitElementVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean isClickable(WebElement element) {
        return  element.isEnabled();
    }
    public boolean isVisible (WebElement element){
        return element.isDisplayed();
    }

    public String getText(WebElement element) {
        try {
            waitElementVisibility(element);

        } catch (NoSuchElementException | TimeoutException e) {
            LogError(e.getRawMessage());
            Assert.fail("[Selenium] : No se puedo realizar el " +Thread.currentThread().getStackTrace()[1].getMethodName()+ " Para el elemento : "+element.toString() +" La clase donde fue llamado es : "+ String.format(("")));

        } catch (Exception e) {
            LogError(e.getMessage());
            Assert.fail("[Selenium] : No se puedo realizar el " +Thread.currentThread().getStackTrace()[1].getMethodName()+ " Para el elemento : "+element.toString() +" La clase donde fue llamado es : "+ String.format(("")));
        }
        return element.getText();
    }

    public void click(WebElement element) {
        try {
            waitElementVisibility(element);
            waitElementClickable(element);
            element.click();


        } catch (NoSuchElementException | TimeoutException e) {
            LogError(e.getRawMessage());
            Assert.fail("[Selenium] : No se puedo realizar el " +Thread.currentThread().getStackTrace()[1].getMethodName()+ "Para el elemento : "+element.toString() +"La clase donde fue llamado es : "+ String.format(("")));


        } catch (Exception e) {
            LogError(e.getMessage());
            Assert.fail("[Selenium] : No se puedo realizar el " +Thread.currentThread().getStackTrace()[1].getMethodName()+ "Para el elemento : "+element.toString() +"La clase donde fue llamado es : "+ String.format(("")));

        }
    }

    public void clickForce(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);


        } catch (NoSuchElementException | TimeoutException e) {
            LogError(e.getRawMessage());
            Assert.fail("[Selenium] : No se puedo realizar el " +Thread.currentThread().getStackTrace()[1].getMethodName()+ " Para el elemento : "+element.toString() +" La clase donde fue llamado es : "+ String.format(("")));


        } catch (Exception e) {
            LogError(e.getMessage());
            Assert.fail("[Selenium] : No se puedo realizar el " +Thread.currentThread().getStackTrace()[1].getMethodName()+ " Para el elemento : "+element.toString() +" La clase donde fue llamado es : "+ String.format(("")));

        }
    }

    public void sendKeys(WebElement element, String text) {
        try {
            waitElementVisibility(element);
            element.clear();
            element.sendKeys(text);
        } catch (NoSuchElementException | TimeoutException e) {
            LogError(e.getRawMessage());
            Assert.fail("[Selenium] : No se puedo realizar el " +Thread.currentThread().getStackTrace()[1].getMethodName()+ " Para el elemento : "+element.toString() +" La clase donde fue llamado es : "+ String.format(("")));


        } catch (Exception e) {
            LogError(e.getMessage());
            Assert.fail("[Selenium] : No se puedo realizar el " +Thread.currentThread().getStackTrace()[1].getMethodName()+ " Para el elemento : "+element.toString() +" La clase donde fue llamado es : "+ String.format(("")));

        }
    }

    public void focusElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", element);
        } catch (NoSuchElementException | TimeoutException e) {
            LogError(e.getRawMessage());
            Assert.fail("[Selenium] : No se puedo realizar el " +Thread.currentThread().getStackTrace()[1].getMethodName()+ " Para el elemento : "+element.toString() +" La clase donde fue llamado es : "+ String.format(("")));


        } catch (Exception e) {
            Assert.fail("[Selenium] : No se puedo realizar el " +Thread.currentThread().getStackTrace()[1].getMethodName()+ " Para el elemento : "+element.toString() +" La clase donde fue llamado es : "+ String.format(("")));

        }
    }

    public void newTab() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void closeTab() {
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }


    public static void clickFirsElement(List<WebElement> elementos) {
        try {

            WebElement elementsExistent = null;
            for (WebElement element : elementos) {
                if (element != null && element.isEnabled() && element.isDisplayed()) {
                    elementsExistent = element;
                    break;
                }
            }

            if (elementsExistent != null) {
                elementsExistent.click();
            } else {
                LogError("Ninguno de los elementos existe o es visible, clickeable y presente");
                Assert.fail("[Selenium] : Ninguno de los elementos existe o es visible, clickeable y presente ");

            }

        } catch (NoSuchElementException | TimeoutException e) {
            LogError(e.getRawMessage());
            Assert.fail("[Selenium] : No se puedo realizar el " +Thread.currentThread().getStackTrace()[1].getMethodName()+ " Para el elemento : "+elementos.toString() +" La clase donde fue llamado es : "+ String.format(("")));


        } catch (Exception e) {
            LogError(e.getMessage());
            Assert.fail("[Selenium] : No se puedo realizar el " +Thread.currentThread().getStackTrace()[1].getMethodName()+ " Para el elemento : "+elementos.toString() +" La clase donde fue llamado es : "+ String.format(("")));

        }
    }
}
