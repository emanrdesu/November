import org.testng.Assert;
import org.testng.annotations.Test;

import page.SliderPage;
import control.Slider;

public class SliderTests extends TestBase {

    private void canSetValue(String expectedValue) {
        SliderPage page = new SliderPage(this.driver);
        page.navigate();
        Slider slider = page.getSlider();
        slider.setValue(expectedValue);
        var actualValue = slider.getValue();
        Assert.assertEquals(actualValue, expectedValue, "Slider value expected");
    }

    @Test
    public void canSetBiggerValue() {
        canSetValue("80");
    }

    @Test
    public void canSetLesserValue() {
        canSetValue("17");
    }

    @Test
    public void canSetMinimumValue() {
        canSetValue("0");
    }

    @Test
    public void canSetMaximumValue() {
        canSetValue("100");
    }

    // for fun
    @Test
    public void cannotGoBeyondLowerLimit() {
        String expectedValue = "0";

        SliderPage page = new SliderPage(this.driver);
        page.navigate();
        Slider slider = page.getSlider();
        slider.setValue("-1");

        var actualValue = slider.getValue();
        Assert.assertEquals(actualValue, expectedValue, "Slider value expected");
    }

    @Test
    public void cannotGoBeyondUpperLimit() {
        String expectedValue = "100";

        SliderPage page = new SliderPage(this.driver);
        page.navigate();
        Slider slider = page.getSlider();
        slider.setValue("115");

        var actualValue = slider.getValue();
        Assert.assertEquals(actualValue, expectedValue, "Slider value expected");
    }
}