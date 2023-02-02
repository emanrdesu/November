package driver;

import java.util.HashMap;

public class DriverManagerFactory {
    private static HashMap<String, DriverManager> managerCache = new HashMap<>();
    
    private static DriverManager createManager(String browser) throws IllegalArgumentException {
        if (browser.equals("chrome"))
            return new ChromeDriverManager();
        else if (browser.equals("edge"))
            return new EdgeDriverManager();
        else
            throw new IllegalArgumentException("browser type not supported");
    }

    public static DriverManager getManager(String browser) {
        DriverManager manager = managerCache.get(browser);
        if (manager == null)
            managerCache.put(browser, createManager(browser));
        
        return managerCache.get(browser);
    }
}