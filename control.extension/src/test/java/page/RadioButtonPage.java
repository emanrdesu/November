package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import control.RadioGroup;

public class RadioButtonPage extends Page {

    @FindBy(how=How.XPATH, using="//div[@class='mb-3']/..")
    private WebElement radioGroupElement;

    public RadioButtonPage(WebDriver driver) {
        super(driver);
        this.index = "https://demoqa.com";
        this.route = "/radio-button";
    }

    public RadioGroup getRadioGroup() {
        return new RadioGroup(radioGroupElement);
    }

    @Override
    public RadioButtonPage navigate() {
        return (RadioButtonPage) super.navigate();
    }
}