package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;

    public BaseTest(WebDriver driver) {
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public WebElement findElement(By by){
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by){
        return driver.findElements(by);
    }

    public void clickElement(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }

    public void sendKey(By by,String text){
        findElement(by).sendKeys(text);
    }
    public void sendKey(By by, Keys key){
        findElement(by).sendKeys(key);
    }

    public void scroll(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
    }
}
