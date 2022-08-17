package steps;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ImdbMoviePage;

import java.util.List;

public class MoviePageSteps extends BaseTest {

    RequestSpecification httpRequest = RestAssured.given();

    public MoviePageSteps(WebDriver driver) {
        super(driver);
    }

    public String directorInfo() {
        return findElement(ImdbMoviePage.DIRECTOR_TEXT).getText();
    }

    public String writerInfo() {
        return findElement(ImdbMoviePage.WRITER_TEXT).getText();
    }

    public List<WebElement> starsInfo() {
        return findElements(ImdbMoviePage.STARS_TEXT);
    }

    public List<WebElement> imagesList() {
        return findElements(ImdbMoviePage.IMAGES_LINKS);
    }

    public boolean checkStarsInfo(List<String> starsText, List<String> starsSearchText) {
        boolean isStarsSame=false;
        for (String star : starsText) {
            for (String starSearch : starsSearchText) {
                if (star.equals(starSearch)) {
                    isStarsSame = true;
                }
            }
        }
        return isStarsSame;
    }

    public boolean checkImagesStatus() {
        boolean isImagesFine=false;
        List<WebElement> imagesLinks = imagesList();

        for (WebElement element : imagesLinks) {
            Response response = httpRequest.get(element.getAttribute("href"));
            if (response.getStatusCode() == 200) {
                isImagesFine = true;
            }
        }
        return isImagesFine;
    }
}
