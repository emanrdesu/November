package control;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Slider extends Control {
    private WebElement slider;

    public Slider(WebElement element) {
        super(element);
        this.slider = element.findElement(By.xpath(".//span/input"));
    }

    private WebElement getElement() {
        return this.slider;
    }

    private void sendKey(String direction) {
        getElement().sendKeys(direction.equals("left") ? Keys.ARROW_LEFT : Keys.ARROW_RIGHT);
    }

    public void setValue(String value) {
        int elementValue = Integer.parseInt(getValue());
        int newValue = Integer.parseInt(value);

        for(int i = 0; i < Math.abs(elementValue - newValue); i++)
            sendKey(newValue < elementValue ? "left" : "right");
    }

    public String getValue() {
        return getElement().getAttribute("value");
    }
}