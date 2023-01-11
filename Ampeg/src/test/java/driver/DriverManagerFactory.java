package driver;

public class DriverManagerFactory {
    public static DriverManager getManager(String browser) {
        if (browser.equals("chrome"))
            return new ChromeDriverManager();
        else if (browser.equals("edge"))
            return new EdgeDriverManager();
        else
            return null;
    }
}