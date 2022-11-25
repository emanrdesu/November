import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import org.openqa.selenium.WebDriver;
import ampeg_auto.DriverManager;
import ampeg_auto.DriverManagerFactory;

public class Sanity {
    private DriverManager driverManager;

    @BeforeTest
    public void setup() {
        String browserType = "chrome";
        driverManager = DriverManagerFactory.getManager(browserType);
        driverManager.createDriver();
    }

    @AfterTest
    public void cleanup() {
        driverManager.quitDriver();
    }

    @Test
    public void canLaunchWebDriver() {
      var url = "https://ampeg.com/index.html";
      WebDriver driver = driverManager.getDriver();
      
      driver.navigate().to(url);
      Assert.assertEquals(driver.getCurrentUrl(), url, "Ampeg URL expected");
  }
}