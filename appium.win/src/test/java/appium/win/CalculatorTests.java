package appium.win;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.service.local.AppiumServiceBuilder;

public class CalculatorTests {

    private Calculator calculator;

    @BeforeTest
    public void setup() {
        var builder = new AppiumServiceBuilder();
        builder.usingPort(4327);
        builder.withIPAddress("127.0.0.1");

        this.calculator = new Calculator(builder);
        this.calculator.launch();
    }
 
    @AfterTest
    public void cleanup() {
        this.calculator.kill();
    }
    
    @Test
    public void canAdd() {
        var number1 = 1;
        var number2 = 3;
        var expectedResults = "Display is 4";

        calculator.add(number1, number2);
        var actualResults = calculator.getResults();
        Assert.assertEquals(actualResults, expectedResults, "4 expected.");
    }
    
    @Test
    public void canSubstract() {
        var number1 = 5;
        var number2 = 3;
        
        var expectedResults = "Display is 2";
        calculator.substract(number1, number2);
        
        var actualResults = calculator.getResults();
        Assert.assertEquals(actualResults, expectedResults, "2 expected.");       
    }
}