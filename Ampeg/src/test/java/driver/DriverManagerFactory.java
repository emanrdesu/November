package driver;

public class DriverManagerFactory {
    public static DriverManager getManager(String browser) throws IllegalArgumentException {
        if (browser.equals("chrome"))
            return new ChromeDriverManager();
        else if (browser.equals("edge"))
            return new EdgeDriverManager();
        else
            throw new IllegalArgumentException();
    }
}