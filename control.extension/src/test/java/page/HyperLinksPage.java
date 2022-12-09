package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import control.HyperLink;

public class HyperLinksPage extends Page {

    @FindBy(how=How.XPATH, using="//p/a[@id='created']")
    private WebElement link;

    public HyperLinksPage(WebDriver driver) {
        super(driver);
        this.index = "https://demoqa.com";
        this.route = "/links";
    }

    public HyperLink getCreatedLink() {
        return new HyperLink(this.link);
    }

    public String getStatusCode() {
        return this.driver.findElement(By.cssSelector("p#linkResponse b")).getText();
    }
}