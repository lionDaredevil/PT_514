package drivers;

import constants.BrowserNames;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    public WebDriver getDriver(BrowserNames browserName){
        switch (browserName){
            case CROME:break;
            case FIREFOX:break;
            
        }
    }
}
