package driver;

public class DriverManagerFactory {
    public static DriverManager getManager(String browser) {
        if (browser.equals("chrome"))
            return new ChromeDriverManager();

        if (browser.equals("edge"))
            return new EdgeDriverManager();
        
        throw new IllegalArgumentException("browser: " + browser + " is not supported.");
    }
}