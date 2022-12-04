import org.testng.Assert;
import org.testng.annotations.Test;

import control.MultiSelect;
import page.SelectMenuPage;

public class MultiSelectTests extends TestBase {
    @Test
    public void canSelectMultipleOptions() {
        String[] expectedOptions = {"Blue", "Black"};
        MultiSelect multiSelect = new SelectMenuPage(this.driver)
                                        .navigate()
                                        .getMultiSelectMenu();

        for(String option : expectedOptions)
            multiSelect.select(option);

        String[] actualOptions = multiSelect.getSelected();

        Assert.assertEquals(actualOptions.length, expectedOptions.length, "Same amount of options expected");

        for(int i = 0; i < actualOptions.length; i++)
            Assert.assertEquals(actualOptions[i], expectedOptions[i], "Selected option expected");
    }
}