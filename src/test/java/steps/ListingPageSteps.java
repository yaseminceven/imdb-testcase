package steps;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListingPageSteps extends BaseTest {
    public ListingPageSteps(WebDriver driver) {
        super(driver);
    }

    public void clickResult(String movieName) {
        try{
            clickElement(By.xpath("//div[@class='findSection'][contains(.,'Titles')]//a[contains(.,'"+movieName+"')]"));
        }catch (Exception ignored){
            clickElement(By.xpath("//li[contains(.,'"+movieName+"')]"));
        }
    }
}
