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

        this.driver
            .findElement(By.cssSelector("#mce-MMERGE5"))
            .sendKeys("U"); // selects United States

        this.driver
            .findElement(By.cssSelector("#mc-embedded-subscribe"))
            .click();
     }

    public boolean subscribeSucess() {
        String expected = "Thank you for subscribing!";
        String xpath = "//div[text()='" + expected + "']";

        try {
            this.driver.findElement(By.xpath(xpath));
            return true;
        }
        catch (NoSuchElementException e) {
            e.printStackTrace();
            return false;
        }
    }
}