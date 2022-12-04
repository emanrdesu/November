package control;

import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class MultiSelect extends Control {

    public MultiSelect(WebElement element) {
        super(element);
    }

    private WebElement getInputElement() {
        return this.element.findElement(By.cssSelector("#react-select-4-input"));
    }

    public void select(String option) {
        WebElement inputElement = getInputElement();
        inputElement.sendKeys(option);
        inputElement.sendKeys(Keys.ENTER);
        inputElement.sendKeys(Keys.ESCAPE);
    }

    public String[] getSelected() {
        return this.element
                   .findElements(By.xpath("//div[@class='css-12jo7m5']"))
                   .stream()
                   .map(WebElement::getText)
                   .collect(Collectors.toList())
                   .toArray(new String[0]);
    }
}