package control;
import org.openqa.selenium.WebElement;

public class Control {

    protected WebElement element;
    
    public Control(WebElement element) {
        this.element = element;
    }
}