package objects.pages;

import farmework.browsers.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MainPage {
    private static final String LOGIN_BUTTON_LOC = String.format("div.auth-bar__item:first-child");
    public static final String USERBAR_ELEMENT_LOC = String.format("userbar");
    public static final String CATALOGUE_LINK_LOC = String.format("Каталог");

    public void clickOnLoginButton(){
        WebDriverWait wait = new WebDriverWait(Browser.getInstance().getWebDriver(), 15);
        WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(LOGIN_BUTTON_LOC)));
        loginButton.click();
    }


    Boolean isPresent = browser.getWebDriver().findElements(By.id(USERBAR_ELEMENT_LOC)).size() > 0;
        Assert.assertTrue(isPresent);
    WebElement catalogue = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(CATALOGUE_LINK_LOC)));
        catalogue.click();
}
