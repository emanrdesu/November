package driver;
import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;

    public abstract void createDriver();

    public WebDriver getDriver() {
        return this.driver;
    }

    public void quitDriver() {
        this.driver.quit();
    }
}