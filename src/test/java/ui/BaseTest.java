package ui;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeMethod
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(true)
        );
        page = browser.newPage();
    }

    @AfterMethod
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}