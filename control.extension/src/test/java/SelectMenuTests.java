import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.SelectMenuPage;

public class SelectMenuTests extends TestBase {
    @Test
    public void canSetAndGetValue() {
        var expectedText = "Purple";

        SelectMenuPage page = new SelectMenuPage(this.driver);
        page.navigate();
        Select selectMenu = page.getSelectMenu();
        selectMenu.selectByVisibleText("Purple");

        var actualText = selectMenu.getFirstSelectedOption().getText();

        Assert.assertEquals(actualText, expectedText, "Option expected.");
    }
    
    @Test
    public void canGetAllOptions() {
        String[] expectedOptions =  {
                "Red",
                "Blue",
                "Green",
                "Yellow",
                "Purple",
                "Black",
                "White",
                "Voilet",
                "Indigo",
                "Magenta",
                "Aqua"
        };

        SelectMenuPage page = new SelectMenuPage(this.driver);
        page.navigate();

        String[] actualOptions = page.getSelectMenu()
                                        .getOptions().stream()
                                        .map(WebElement::getText)
                                        .collect(Collectors.toList())
                                        .toArray(new String[0]);

        for(int i = 0; i < actualOptions.length; i++)
            Assert.assertEquals(actualOptions[i], expectedOptions[i], "Option expected.");
    }
}