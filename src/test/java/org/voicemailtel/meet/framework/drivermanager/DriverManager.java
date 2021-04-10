package org.voicemailtel.meet.framework.drivermanager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.voicemailtel.meet.framework.config.AppConfig;
import org.voicemailtel.meet.framework.utils.Constants;

public class DriverManager {
    private WebDriver driver;
    private static DriverManager manager;

    private DriverManager() {
        if (((String) AppConfig.getProperties("browser.name")).equalsIgnoreCase(Constants.CHROME)) {
            System.setProperty(Constants.CHROME_KEY, (String) AppConfig.getProperties("chrome.driver.path"));
            driver = new ChromeDriver();

        } else if (((String) AppConfig.getProperties("browser.name")).equalsIgnoreCase(Constants.FIREFOX)) {
            System.setProperty(Constants.FIREFOX_KEY, (String) AppConfig.getProperties("firefox.driver.path"));
            driver = new FirefoxDriver();
        } else if (((String) AppConfig.getProperties("browser.name")).equalsIgnoreCase(Constants.EDGE)) {
            System.setProperty(Constants.EDGE_KEY, (String) AppConfig.getProperties("edge.driver.path"));
            driver = new EdgeDriver();
        } else if (((String) AppConfig.getProperties("browser.name")).equalsIgnoreCase(Constants.OPERA)) {
            System.setProperty(Constants.OPERA_KEY, (String) AppConfig.getProperties("opera.driver.path"));
            driver = new OperaDriver();
        }
    }

    public static WebDriver getDriver() {
        if (manager == null) {
            manager = new DriverManager();
        }
        return manager.driver;
    }
}


