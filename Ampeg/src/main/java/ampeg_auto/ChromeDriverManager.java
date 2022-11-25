package ampeg_auto;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {
    final String chromeDriverPath = "/Users/User/Downloads/chromedriver.exe";
    
    @Override
    public void createDriver() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        this.driver = new ChromeDriver();
    }
}