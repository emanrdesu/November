import org.testng.annotations.Test;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import page.RadioButtonPage;

public class RadioGroupTests extends TestBase {

    private final Class<NoSuchElementException> NSEE = NoSuchElementException.class;

    @Test
    public void canSelectButton() {
        var expectedLabel = "Yes";
        var radioGroup = new RadioButtonPage(this.driver)
                              .navigate()
                              .getRadioGroup();

        radioGroup.getButton(expectedLabel).select();
        var actualLabel = radioGroup.getSelected();
        Assert.assertEquals(actualLabel, expectedLabel, "Radio Button label expected.");
    }

    @Test
    public void canSelectButton2() {
        var expectedLabel = "Impressive";
        var radioGroup = new RadioButtonPage(this.driver)
                              .navigate()
                              .getRadioGroup();

        radioGroup.getButton(expectedLabel).select();
        var actualLabel = radioGroup.getSelected();
        Assert.assertEquals(actualLabel, expectedLabel, "Radio Button label expected.");
    }

    @Test
    public void cannotSelectButton() {
        var radioGroup = new RadioButtonPage(this.driver)
                              .navigate()
                              .getRadioGroup();

        radioGroup.getButton("No").select();

        Assert.assertThrows(NSEE, () -> radioGroup.getSelected());
    }
}