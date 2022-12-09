import org.testng.Assert;
import org.testng.annotations.Test;

import page.HyperLinksPage;

public class HyperLinkTests extends TestBase {
    @Test
    public void canClickHyperLink() {
        var expectedCode = "201";

        HyperLinksPage page = new HyperLinksPage(this.driver);
        page.navigate();
        page.getCreatedLink().click();

        var actualCode = page.getStatusCode();
        Assert.assertEquals(actualCode, expectedCode, "Status code expected.");
    }
}