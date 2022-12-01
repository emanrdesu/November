package control;

import org.openqa.selenium.WebElement;

public class RadioButton extends Control {

    public RadioButton(WebElement element) {
        super(element);
    }

    public void select() {
        this.element.click();
    }
}