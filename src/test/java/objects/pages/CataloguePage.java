package objects.pages;

import farmework.elements.BrowserElement;
import org.openqa.selenium.By;


public class CataloguePage {
    public static final String CATALOGUE_LINK_LOC = String.format("catalog-navigation");
    public static final String COFFE_CALEGORY_LOC = String.format("Кофе");

    public BrowserElement catalogueLink = new BrowserElement(By.className(CATALOGUE_LINK_LOC));
    public BrowserElement coffeCategory = new BrowserElement(By.linkText(COFFE_CALEGORY_LOC));

    public void cataloguePageIsVisible(){
        catalogueLink.isVisible();
    }
    public void openCoffeCategory(){
        coffeCategory.click();
    }



}
