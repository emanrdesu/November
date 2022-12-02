import org.testng.annotations.Test;
import org.testng.Assert;

import page.*;

public class RadioGroupTests extends TestBase {
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
        String expectedLabel = null;
        var radioGroup = new RadioButtonPage(this.driver)
                              .navigate()
                              .getRadioGroup();

        radioGroup.getButton("No").select();
        var actualLabel = radioGroup.getSelected();
        Assert.assertTrue(actualLabel == expectedLabel, "Null label expected");
    }
}