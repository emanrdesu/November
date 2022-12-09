package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import control.Slider;

public class SliderPage extends Page {

    @FindBy(how=How.XPATH, using="//form/div[@id='sliderContainer']/..")
    private WebElement sliderElement;

    public SliderPage(WebDriver driver) {
        super(driver);
        this.index = "https://demoqa.com";
        this.route = "/slider"; 
    }

    public Slider getSlider() {
        return new Slider(sliderElement);
    }
}