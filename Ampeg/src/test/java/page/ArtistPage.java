package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class ArtistPage extends AmpegPage {
    public ArtistPage(WebDriver driver) {
        super(driver);
        this.route = "/artists";
    }
    
    public ArtistPage clickArtist(int id) {
        String xpath = "//a[@href='#artist" + Integer.toString(id) + "']";
        this.driver.findElement(By.xpath(xpath)).click();
        return this;
    }

    public String getArtistName(int id) {
        JavascriptExecutor js = (JavascriptExecutor) this.driver;

        String css = "div#artist" + Integer.toString(id) + " strong";
        WebElement artist = this.driver.findElement(By.cssSelector(css));

        return (String) js.executeScript("return arguments[0].childNodes[0].data", artist);
    }
}