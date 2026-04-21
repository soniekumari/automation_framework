package pages;

import com.microsoft.playwright.Page;

public class CheckoutPage {

    private Page page;

    public CheckoutPage(Page page) {
        this.page = page;
    }

    public void completeOrder() {
        page.fill("#first-name", "Test");
        page.fill("#last-name", "User");
        page.fill("#postal-code", "700001");

        page.click("#continue");
        page.click("#finish");
    }

    public String getConfirmation() {
        return page.locator(".complete-header").innerText();
    }
}