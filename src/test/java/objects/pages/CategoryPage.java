package objects.pages;

import farmework.elements.BrowserElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CategoryPage {

    private static final String COFFE_HEADER_LOC = String.format("//*[@class='schema-header__title']");

    public BrowserElement coffeHeader = new BrowserElement(By.xpath(COFFE_HEADER_LOC));

    public void isCoffePage(){
        Assert.assertEquals(coffeHeader.getText(),"Кофе");
    }


}
