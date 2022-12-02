import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import control.*;
import page.*;

public class HyperlinkTests extends TestBase {
    @Test
    public void canClickHyperLink() {
        var expectedCode = "201";

        HyperLinksPage page = new HyperLinksPage(this.driver);
        page.navigate();

        WebElement element = page.getCreatedLink();

        new HyperLink(element).click();
        var actualCode = page.getStatusCode();
        Assert.assertEquals(actualCode, expectedCode, "Status code expected.");
    }
}