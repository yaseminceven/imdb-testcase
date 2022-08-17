package steps;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.ImdbHomePage;

public class HomePageSteps extends BaseTest {
    public HomePageSteps(WebDriver driver){
        super(driver);
    }

    public void clickOnMenu() {
        clickElement(ImdbHomePage.MENU_BUTTON);
    }

    public void clickAwardEventsListLink(String linkText) {
        clickElement(By.xpath("//span[@class='ipc-list-item__text'][contains(.,'"+linkText+"')]"));
    }

    public void searchMovie(String movieName) {
        sendKey(ImdbHomePage.SEARCH_INPUT,movieName);
        sendKey(ImdbHomePage.SEARCH_INPUT, Keys.ENTER);
    }
}
