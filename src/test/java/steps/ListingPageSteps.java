package steps;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import pages.ImdbListingPage;

public class ListingPageSteps extends BaseTest {
    public ListingPageSteps(WebDriver driver) {
        super(driver);
    }

    public void clickResult(String movieName) {
        if(movieName.equals("The Jazz Singer")){
            clickElement(ImdbListingPage.SECOND_RESULT);
        }else{
            clickElement(ImdbListingPage.THECIRCUS_LINK);
        }
    }
}
