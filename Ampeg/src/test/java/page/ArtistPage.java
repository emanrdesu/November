package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArtistPage extends AmpegPage {
    public ArtistPage(WebDriver driver) {
        super(driver);
        this.route = "/artists";
    }

    public AbbiRothPage clickAbbiRoth() {
        this.driver
            .findElement(By.xpath("//li/a[text()='Abbi Roth']"))
            .click();

        return new AbbiRothPage(this.driver);
    }
}