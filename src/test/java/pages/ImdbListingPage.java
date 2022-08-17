package pages;

import org.openqa.selenium.By;

public class ImdbListingPage {
    public static final By FIRST_RESULT = By.xpath("//table[@class='findList']//td[@class='result_text']/a");
    public static final By SECOND_RESULT = By.xpath("//table[@class='findList']//tr[@class='findResult even']/td[@class='result_text']/a");

}
