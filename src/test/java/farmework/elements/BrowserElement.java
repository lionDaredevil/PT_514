package farmework.elements;

import farmework.browsers.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BrowserElement {

    private By locator;
    private WebDriverWait wait;
    private Browser browser;


    public BrowserElement(By locator){
        this.locator = locator;
        wait = new WebDriverWait(Browser.getInstance().getWebDriver(), 15);
        browser = Browser.getInstance();
    }

//    public void mouseClick(){
//        BrowserElement element = new BrowserElement(locator);
//        WebElement webElement = element.getClass().
//        Actions action = new Actions(Browser.getInstance().getWebDriver());
//        wait.until(ExpectedConditions.elementToBeClickable(locator));
//        action.moveToElement(element.getClass().).click().perform();
//    }

    public boolean isVisible(){
        //try{
            List<WebElement> webElement = Browser.getInstance().getWebDriver().findElements(locator);
            return (wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver d) {
                    return !(webElement.isEmpty());
                }

            }));

    }
    public String getText() {
        WebElement webElement = Browser.getInstance().getWebDriver().findElement(locator);
        return (wait.until(new ExpectedCondition<String>() {
            @Override
            public String apply(WebDriver d) {
                return webElement.getText();
            }
        }));
    }

    public void click(){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

    }

    public void sendKeys(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);
    }

}
