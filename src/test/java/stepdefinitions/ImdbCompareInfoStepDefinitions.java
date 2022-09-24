package stepdefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ImdbMoviePage;
import steps.HomePageSteps;
import steps.ListingPageSteps;
import steps.MoviePageSteps;
import steps.OscarsPageSteps;

import java.util.ArrayList;
import java.util.List;

public class ImdbCompareInfoStepDefinitions{

    public static WebDriver driver;
    private static String url = "https://www.imdb.com/";

    public static String directorText;
    public static String writerText;
    public static List<String> starsText = new ArrayList<>();
    public static String directorSearchText;
    public static String writerSearchText;
    public static List<String> starsSearchText = new ArrayList<>();

    HomePageSteps homePageSteps = new HomePageSteps(driver);
    ListingPageSteps listingPageSteps = new ListingPageSteps(driver);
    MoviePageSteps moviePageSteps = new MoviePageSteps(driver);
    OscarsPageSteps oscarsPageSteps = new OscarsPageSteps(driver);

    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("User open browser and open the IMDB Page")
    public void userOpenBrowserAndOpenTheImdbPage() {
        driver.get(url);
    }

    @When("User click on Menu button")
    public void userClickOnMenuButton() {
        homePageSteps.clickOnMenu();
    }

    @When("User click on the link that contains text {string} at Awards and Events List")
    public void userClickOnTheLinkThatContainsText(String linkText) {
        homePageSteps.clickAwardEventsListLink(linkText);
    }

    @And("User click on the link that contains text {string} at Event History")
    public void userClickOnTheLinkThatContainsTextAtEventHistory(String yearText) {
        oscarsPageSteps.clickLinkEventHistory(yearText);
    }

    @And("User click on the link that contains text {string} at Honory Award")
    public void userClickOnTheLinkThatContainsTextAtHonoryAward(String movieName) {
        oscarsPageSteps.clickLinkHonoryAward(movieName);
        moviePageSteps.clickTopCredits();
        directorText = moviePageSteps.directorInfo();
        writerText = moviePageSteps.writerInfo();
        List<WebElement> starsWebElement = moviePageSteps.starsInfo();
        starsText = moviePageSteps.starsListText(starsWebElement);
    }

    @When("User returns homepage")
    public void userReturnsHomepage() {
        driver.findElement(ImdbMoviePage.HOMEPAGE_ICON).click();
    }

    @When("User search the movie {string}")
    public void userSearchTheMovie(String movieName){
        homePageSteps.searchMovie(movieName);
        listingPageSteps.clickResult(movieName);
        moviePageSteps.clickTopCredits();
        directorSearchText = moviePageSteps.directorInfo();
        writerSearchText = moviePageSteps.writerInfo();
        List<WebElement> starsWebElement = moviePageSteps.starsInfo();
        starsSearchText = moviePageSteps.starsListText(starsWebElement);
    }

    @Then("User should see same information about the film and images should not be broken")
    public void userShouldSeeSameInformationAboutTheFilmAndImagesShouldNotBeBroken() {
        boolean isStarsSame = moviePageSteps.checkStarsInfo(starsText,starsSearchText);
        boolean movieInfoResult = directorText.equals(directorSearchText) && writerText.equals(writerSearchText) && isStarsSame;
        boolean isImagesFine = moviePageSteps.checkImagesStatus();

        Assert.assertTrue(movieInfoResult && isImagesFine);
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
