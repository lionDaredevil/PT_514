package objects.pages;

import farmework.elements.BrowserElement;
import org.openqa.selenium.By;

public class MainPanel {
    private static final String LOGIN_BUTTON_LOC = String.format("div.auth-bar__item:first-child");
    public static final String USERBAR_ELEMENT_LOC = String.format("//div[@class='b-top-profile js-userbar']");
    public static final String CATALOGUE_PAGE_LINK = String.format("//a[@href='https://catalog.onliner.by/']");

    public BrowserElement loginButton = new BrowserElement(By.cssSelector(LOGIN_BUTTON_LOC));
    public BrowserElement userBar = new BrowserElement(By.xpath(USERBAR_ELEMENT_LOC));
    public BrowserElement cataloguePageLink = new BrowserElement(By.xpath(CATALOGUE_PAGE_LINK));

    public void loginButtonClick(){
        loginButton.click();
    }

    public void userBarIsVisible() {
        userBar.isVisible();
    }
    public void catalogueLinkClick(){
        cataloguePageLink.click();
    }




}
