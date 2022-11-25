package ampeg_auto;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager {
    final String edgeDriverPath = "/Users/User/Downloads/msedgedriver.exe";

    @Override
    public void createDriver() {
        System.setProperty("webdriver.msedge.driver", edgeDriverPath);
        this.driver = new EdgeDriver();
    }
}