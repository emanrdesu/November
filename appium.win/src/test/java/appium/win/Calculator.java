package appium.win;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.windows.WindowsDriver;

public class Calculator {
    private WindowsDriver<RemoteWebElement> driver;
    private AppiumServiceBuilder builder;
    private AppiumDriverLocalService service;

    public Calculator(AppiumServiceBuilder builder) {
        this.builder = builder;
    }

    public void launch() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        caps.setCapability("deviceName", "WindowsPC");

        this.service = AppiumDriverLocalService.buildService(builder);
        this.driver = new WindowsDriver<RemoteWebElement>(service, caps);
    }

    public void kill() {
        this.driver.quit();
    }
    
    public void click(String button) {
        this.driver.findElementByName(button).click();
    }
    
    private String englishName(int x) {
        String string = null;

        switch(x) {
        case 0: string = "Zero"; break;
        case 1: string = "One"; break;
        case 2: string = "Two"; break;
        case 3: string = "Three"; break;
        case 4: string = "Four"; break;
        case 5: string = "Five"; break;
        case 6: string = "Six"; break;
        case 7: string = "Seven"; break;
        case 8: string = "Eight"; break;
        case 9: string = "Nine"; break;
        }

        return string;
    }

    private void operate(String op, int a, int b) {
        click(englishName(a));
        click(op);
        click(englishName(b));
        click("Equals");        
    }

    public void add(int a, int b) {
        operate("Plus", a, b);
    }

    public void substract(int a, int b) {
        operate("Minus", a, b);
    }

    public String getResults() {
        return driver.findElementByAccessibilityId("CalculatorResults").getText();
    }
}