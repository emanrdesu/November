package control;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class RadioGroup extends Control {

    public RadioGroup(WebElement element) {
        super(element);
    }

    public RadioButton getButton(String label) {
        String xpath = "//label[text()='" + label + "']/../label";
        WebElement button = this.element.findElement(By.xpath(xpath));
        return new RadioButton(button);
    }

    public String getSelected() {
        try {
            WebElement clicked = this.element.findElement(By.xpath("//p/span"));
            return clicked.getText();
        }
        catch(NoSuchElementException e) {
            e.printStackTrace();
            return null;
        }
    }
}