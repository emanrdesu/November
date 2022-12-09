package control;
import org.openqa.selenium.WebElement;

public abstract class Control {

    protected WebElement element;

    public Control(WebElement element) {
        this.element = element;
    }

    public void click() {
        this.element.click();
    }
}