package page;
import org.openqa.selenium.WebDriver;

public abstract class Page {
    protected String index;
    protected String route;
    protected WebDriver driver;

    public String getURL() {
        return index + route;
    }
    
    public Page navigate() {
        this.driver.navigate().to(getURL());
        return this;
    }
}