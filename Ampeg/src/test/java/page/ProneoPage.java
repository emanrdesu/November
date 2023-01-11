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
            .findElement(By.xpath("//h2[text()='PN-410HLF']/../a"))
            .click();

        return new PN410HLFPage(this.driver);
    }
}