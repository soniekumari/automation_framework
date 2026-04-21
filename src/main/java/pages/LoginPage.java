package pages;

import com.microsoft.playwright.Page;
import utils.ConfigReader;

public class LoginPage {

    private Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public void login(String user, String pass) {
        page.navigate(ConfigReader.get("uiUrl"));
        page.fill("#user-name", user);
        page.fill("#password", pass);
        page.click("#login-button");
    }
}