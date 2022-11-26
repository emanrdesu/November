package page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmpegHome extends AmpegPage {
    public AmpegHome(WebDriver driver) {
        super(driver);
        this.route = "";
        this.driver.navigate().to(getURL());
    }

    public ArtistPage clickArtistsPage() {
        this.driver
          .findElement(By.cssSelector("a[title=Artists]"))
          .click();

        return new ArtistPage(this.driver);
    }

    public ProductsPage clickProductsPage() {
        this.driver
            .findElement(By.cssSelector("a[title=Products]"))
            .click();

        return new ProductsPage(this.driver);
    }
}