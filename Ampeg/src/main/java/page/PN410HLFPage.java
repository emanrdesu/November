package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PN410HLFPage extends AmpegPage {

    public PN410HLFPage(WebDriver driver) {
        super(driver);
        this.route = "/products/proneo/pn410hlf";
    }

    public String getSensitivity() {
        String xpath = "//div[@class='specsCopy']//strong[text()='Sensitivity']/..";

        return this.driver
                .findElement(By.xpath(xpath))
                .getText();
    }
}