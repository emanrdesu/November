package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
    protected String index;
    protected String route;
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String getURL() {
        return index + route;
    }
    
    public Page navigate() {
        this.driver.navigate().to(getURL());
        return this;
    }
}