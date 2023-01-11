package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends AmpegPage {

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.route = "/products";
    }

    public HeritagePage clickHeritagePage() {
        this.driver
            .findElement(By.cssSelector("a[href='/products/heritage/splash']"))
            .click();

        return new HeritagePage(this.driver);
    }

    public ProneoPage clickProneoSeriesPage() {
        this.driver
            .findElement(By.cssSelector("a[href='/products/pro/']"))
            .click();

        return new ProneoPage(this.driver);
    }
}