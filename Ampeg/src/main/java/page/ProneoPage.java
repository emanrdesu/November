package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProneoPage extends AmpegPage {

    public ProneoPage(WebDriver driver) {
        super(driver);
        this.route = "/products/proneo";
    }

    public PN410HLFPage clickPN410LFPage() {
        this.driver
            .findElement(By.cssSelector("a[href='/products/proneo/pn410hlf/']"))
            .click();

        return new PN410HLFPage(this.driver);
    }
}