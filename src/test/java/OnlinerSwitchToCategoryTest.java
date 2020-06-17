import farmework.BaseTest;
import objects.pages.CataloguePage;
import objects.pages.CategoryPage;
import objects.pages.LoginPage;
import objects.pages.MainPanel;
import org.testng.annotations.Test;

public class OnlinerSwitchToCategoryTest extends BaseTest {
    private MainPanel mainPanel = new MainPanel();
    private LoginPage loginPage = new LoginPage();
    private CataloguePage cataloguePage = new CataloguePage();
    private CategoryPage categoryPage = new CategoryPage();

    @Test
    public void runTest() {
        mainPanel.loginButtonClick();
        loginPage.login();
        mainPanel.userBarIsVisible();
        mainPanel.catalogueLinkClick();
        cataloguePage.cataloguePageIsVisible();
        cataloguePage.openCoffeCategory();
        categoryPage.isCoffePage();
     }
}
