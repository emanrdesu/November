package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PN410HLFPage extends AmpegPage {

    public PN410HLFPage(WebDriver driver) {
        super(driver);
        this.route = "/products/proneo/pn410hlf";
    }

    public String getWeight() {
        String css = "div.col-xs-22 ul li";

        return this.driver
                .findElements(By.cssSelector(css))
                .get(4)
                .getText();
    }
}