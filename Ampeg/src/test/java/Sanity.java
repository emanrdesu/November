import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import driver.DriverManager;
import driver.DriverManagerFactory;
import page.*;

public class Sanity {
    private DriverManager driverManager;
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        String browserType = "chrome";

        driverManager = DriverManagerFactory.getManager(browserType);
        driverManager.createDriver();
        driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void cleanup() {
        driverManager.quitDriver();
    }

    @Test
    public void canLaunchWebDriver() {
      var url = "https://ampeg.com/index.html";
      driver.navigate().to(url);
      Assert.assertEquals(driver.getCurrentUrl(), url, "Ampeg URL expected");
    }

    @Test
    public void canGetArtistName() {
        String expectedName = "Abbi Roth";
        String actualName = new AmpegHome(this.driver)
                               .navigate()
                               .clickArtistsPage()
                               .clickAbbiRoth()
                               .getArtistName();

        Assert.assertEquals(actualName, expectedName, "Artist name expected");
    }

    @Test
    public void canSignUpToMailingList() {
        String expectedText = "Thank you for subscribing!";
        String xpath = "//div[text()='" + expectedText + "']";

        HeritagePage heritage = new AmpegHome(this.driver)
                                    .navigate()
                                    .clickProductsPage()
                                    .clickHeritagePage();

        heritage.signUpToMailingList();
        var actualText = driver.findElement(By.xpath(xpath)).getText();

        String errorMessage = "Successful mailing list signup text expected.";
        Assert.assertEquals(actualText, expectedText, errorMessage);
    }
    
    @Test
    public void canGetSensitivity() {
        String expected = "Sensitivity: 98dB";
        String actual = new AmpegHome(this.driver)
                            .navigate()
                            .clickProductsPage()
                            .clickProneoSeriesPage()
                            .clickPN410LFPage()
                            .getSensitivity();

        var errorMessage = "Product sensitivity expected.";
        Assert.assertEquals(actual, expected, errorMessage);
    }
}