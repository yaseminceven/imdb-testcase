package pages;

import org.openqa.selenium.By;

public class ImdbMoviePage {
    public static final By HOMEPAGE_ICON = By.id("home_img_holder");
    public static final By TOP_CREDITS_LINK = By.xpath("//div[@class='sc-fa02f843-2 dwQKsL']/button");
    public static final By DIRECTOR_TEXT = By.xpath("//div[@class='sc-fa02f843-0 fjLeDR']/ul/li[1]//a");
    public static final By WRITER_TEXT = By.xpath("//div[@class='sc-fa02f843-0 fjLeDR']/ul/li[2]//a");
    public static final By STARS_TEXT = By.xpath("//div[@class='sc-fa02f843-0 fjLeDR']/ul/li[3]/div[@class='ipc-metadata-list-item__content-container']//li/a");
    public static final By IMAGES_LINKS = By.cssSelector(".ipc-lockup-overlay.ipc-focusable");
}
