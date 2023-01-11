

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driver.DriverManager;
import driver.DriverManagerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.AmpegHome;
import page.ArtistPage;
import page.HeritagePage;
import page.PN410HLFPage;
import page.ProductsPage;
import page.ProneoPage;

public class Actions {
    protected DriverManager driverManager;
    protected WebDriver driver;

    public Actions() {
        String browserType = "chrome";
        this.driverManager = DriverManagerFactory.getManager(browserType);
        this.driverManager.createDriver();
        this.driver = driverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    
    @Given("User launches index page")
    public void user_launches_index() {
        new AmpegHome(this.driver).navigate();
    }

    @Given("clicks artists page")
    public void user_clicks_on_artist_page() {
        new AmpegHome(this.driver).clickArtistsPage();
    }
    
    @Given("clicks products page")
    public void user_clicks_products_page() {
        new AmpegHome(this.driver).clickProductsPage();
    }
    
    @Given("clicks heritage page")
    public void user_clicks_heritage_page() {
        new ProductsPage(this.driver).clickHeritagePage();
    }

    
    
    @When("user clicks on artist with id {int}")
    public void user_clicks_on_artist(Integer id) {
        new ArtistPage(this.driver).clickArtist(id);
    }

    @Then("artist name with id {int} should be {string}")
    public void artist_name_should_be(Integer id, String expectedName) {
        var artistName = new ArtistPage(this.driver).getArtistName(id);
        Assert.assertEquals(expectedName, artistName, "Artist name expected");
        this.driverManager.quitDriver();
    }
    
    
    @When("user fills out mailing list form")
    public void user_fills_out_mailing_list_form() {
        new HeritagePage(this.driver).signUpToMailingList();
    }
     
    @Then("a successful sign up message should show")
    public void a_successful_sign_up_message_should_show() {
        String expectedText = "Thank you for subscribing!";
        String xpath = "//div[text()='" + expectedText + "']";
        var actualText = driver.findElement(By.xpath(xpath)).getText();

        String errorMessage = "Successful mailing list signup text expected.";
        Assert.assertEquals(actualText, expectedText, errorMessage);
        this.driverManager.quitDriver();
    }
    
    
     @Given("clicks proneo series page")
    public void clicks_proneo_series_page() {
        new ProductsPage(this.driver).clickProneoSeriesPage();
    }

    @When("user clicks on PN410LF product page")
    public void clicks_pn410lf_product_page() {
        new ProneoPage(this.driver).clickPN410LFPage();
    }

    @Then("user can see product's weight is {string}")
    public void user_can_see_product_s_weight(String expectedWeight) {
        var actualWeight = new PN410HLFPage(this.driver).getWeight();
        Assert.assertEquals(actualWeight, expectedWeight, "Product weight expected");
        this.driverManager.quitDriver();
    }
}