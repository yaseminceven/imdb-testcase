package pages;

import org.openqa.selenium.By;

public class ImdbListingPage {
    public static final By THECIRCUS_LINK = By.xpath("//td[@class='result_text']/a[contains(.,'The Circus')]");
    public static final By SECOND_RESULT = By.xpath("//table[@class='findList']//tr[@class='findResult even']/td[@class='result_text']/a");

}
