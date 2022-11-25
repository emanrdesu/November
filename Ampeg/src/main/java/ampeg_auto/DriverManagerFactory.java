package ampeg_auto;

public class DriverManagerFactory {
    public static DriverManager getManager(String browser) {
        if (browser.equals("chrome"))
            return new ChromeDriverManager();
        else
            return new EdgeDriverManager();
    }
}