import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.openqa.selenium.WebDriver;
import driver.DriverManager;
import driver.DriverManagerFactory;

public abstract class TestBase {

    protected DriverManager driverManager;
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        String browserType = "chrome";
        driverManager = DriverManagerFactory.getManager(browserType);
        driverManager.createDriver();
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void cleanup() {
        driverManager.quitDriver();
    }
}