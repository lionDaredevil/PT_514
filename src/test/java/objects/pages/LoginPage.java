package objects.pages;

import farmework.elements.BrowserElement;
import farmework.reader.Config;
import org.openqa.selenium.By;

import java.io.IOException;


public class LoginPage {
    private static final String LOGIN_FIELD_LOC = String.format("input[placeholder=\"Ник или e-mail\"]");
    private static final String PASSWORD_FIELD_LOC = String.format("input[placeholder=\"Пароль\"]");
    private static final String LOGIN_BUTTON_LOC = String.format("button.auth-button");

    public BrowserElement loginButton = new BrowserElement(By.cssSelector(LOGIN_BUTTON_LOC));
    public BrowserElement loginField = new BrowserElement(By.cssSelector(LOGIN_FIELD_LOC));
    public BrowserElement passwordField = new BrowserElement(By.cssSelector(PASSWORD_FIELD_LOC));

    public void login(){

        try {
            loginField.sendKeys(Config.getProperty("userName"));
            passwordField.sendKeys(Config.getProperty("password"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        loginButton.click();
    }


}
