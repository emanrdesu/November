package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import control.MultiSelect;

public class SelectMenuPage extends Page {

    private final String oldStyleSelectCSS = "#oldSelectMenu";
    @FindBy(how=How.CSS, using=oldStyleSelectCSS)
    private WebElement oldStyleSelectMenu;

    private final String multiSelectXPATH = "//input[@id='react-select-4-input']/../../../../.."; 
    @FindBy(how=How.XPATH, using=multiSelectXPATH)
    private WebElement multiSelectMenu;

    public SelectMenuPage(WebDriver driver) {
        super(driver);
        this.index = "https://demoqa.com";
        this.route = "/select-menu";
    }

    public Select getSelectMenu() {
        return new Select(oldStyleSelectMenu);
    }

    public MultiSelect getMultiSelectMenu() {
        return new MultiSelect(multiSelectMenu);
    }

    public SelectMenuPage navigate() {
        super.navigate();
        return this;
    }
}