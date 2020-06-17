package farmework.browsers;

import constants.BrowserNames;
import farmework.drivers.DriverFactory;
import farmework.reader.Config;
import org.openqa.selenium.WebDriver;



public class Browser {
    private static Browser browser = null;
    private static DriverFactory driverFactory = new DriverFactory();
    private WebDriver webDriver;


    private Browser() {

    }

    public static Browser getInstance(){
        if (browser == null) {
            browser = new Browser();
            BrowserNames browserName = BrowserNames.CHROME;

            try {
                browserName = BrowserNames.valueOf(Config.getProperty("browserName").toUpperCase());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            browser.webDriver = driverFactory.getDriver(browserName);
        }
        return browser;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void close() {
        webDriver.close();
        webDriver = null;
        browser = null;
    }

    public void open(String url) {
        webDriver.get(url);
    }


}
