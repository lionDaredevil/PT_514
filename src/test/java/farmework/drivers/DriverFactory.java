package farmework.drivers;

import constants.BrowserNames;
import farmework.reader.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.nio.file.Paths;

public class DriverFactory {
    public WebDriver getDriver(BrowserNames browserName){
        WebDriver webDriver = null;
        switch (browserName){
            case FIREFOX:BrowserNames.FIREFOX.getBrowserName();
            webDriver = getFireFoxDriver();
            break;
            case SAFARI:BrowserNames.SAFARI.getBrowserName();
            webDriver = getSafariDriver();
            webDriver.manage().window().maximize();
            break;
            case CHROME:
            default:BrowserNames.CHROME.getBrowserName();
            webDriver = getChromeDriver();
            break;

        }
        return webDriver;
    }

    public ChromeDriver getChromeDriver(){
        try {
            System.setProperty(Config.getProperty("wedriverChromeName"), Paths.get(Config.getProperty("chromeDriverPath"))
                    .toAbsolutePath().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ChromeDriver();
    }

    public FirefoxDriver getFireFoxDriver(){
        try {
            System.setProperty(Config.getProperty("wedriverFirefoxName"), Paths.get(Config.getProperty("firefoxDriverPath"))
                    .toAbsolutePath().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new FirefoxDriver();
    }

    public SafariDriver getSafariDriver(){
        try {
            System.setProperty(Config.getProperty("wedriverSafariName"), Paths.get(Config.getProperty("safariDriverPath"))
                    .toAbsolutePath().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new SafariDriver();
    }
}
