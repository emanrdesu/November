package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HeritagePage extends AmpegPage {

    public HeritagePage(WebDriver driver) {
        super(driver);
        this.route = "/products/heritage";
    }
    
    private String getRandomEmailAddress() {
        int x = (int) System.currentTimeMillis() % 100;
        return "fake" + Integer.toString(x) + "@email.com";
    }

    public void signUpToMailingList() {
        this.driver
            .findElement(By.cssSelector("#mce-EMAIL"))
            .sendKeys(getRandomEmailAddress());

        var unitedStates = "U";

        this.driver
            .findElement(By.cssSelector("#mce-MMERGE5"))
            .sendKeys(unitedStates);

        this.driver
            .findElement(By.cssSelector("#mc-embedded-subscribe"))
            .click();
     }
}