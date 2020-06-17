package farmework;

import farmework.browsers.Browser;
import farmework.reader.Config;
import org.testng.annotations.*;

import java.io.IOException;

public class BaseTest {
    protected Browser browser;

    @BeforeMethod
    public void beforeTest(){
        browser = Browser.getInstance();
        try {
            browser.open(Config.getProperty("url"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void teardown() {
        browser.close();
}
}
