package page;
import org.openqa.selenium.WebDriver;

public class AmpegPage extends Page {
    public AmpegPage(WebDriver driver) {
        this.index = "https://ampeg.com";
        this.driver = driver;
    }
}