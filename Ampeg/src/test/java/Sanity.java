import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import ampeg_auto.DriverManager;
import ampeg_auto.DriverManagerFactory;

public class Sanity {
    private DriverManager driverManager;
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        String browserType = "chrome";

        driverManager = DriverManagerFactory.getManager(browserType);
        driverManager.createDriver();
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void cleanup() {
        driverManager.quitDriver();
    }

    @Test
    public void canLaunchWebDriver() {
      var url = "https://ampeg.com/index.html";
      driver.navigate().to(url);
      Assert.assertEquals(driver.getCurrentUrl(), url, "Ampeg URL expected");
  }
}