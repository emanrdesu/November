package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AbbiRothPage extends AmpegPage {
    public AbbiRothPage(WebDriver driver) {
        super(driver);
        this.route = "/artists/271/Abbi Roth";
    }

    public String getArtistName() {
        return this.driver.findElement(By.xpath("//h3/a[text()='Abbi Roth']")).getText();
    }
}