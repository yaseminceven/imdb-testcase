package steps;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OscarsPageSteps extends BaseTest {
    public OscarsPageSteps(WebDriver driver) {
        super(driver);
    }

    public void clickLinkEventHistory(String yearText) {
        clickElement(By.xpath("//a[contains(.,'"+yearText+"')]"));
    }

    public void clickLinkHonoryAward(String movieName) {
        clickElement(By.xpath("//a[contains(.,'"+movieName+"')]"));
    }
}
