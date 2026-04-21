package pages;

import com.microsoft.playwright.Page;

public class InventoryPage {

    private Page page;

    public InventoryPage(Page page) {
        this.page = page;
    }

    public void sortHighToLow() {
        page.selectOption(".product_sort_container", "hilo");
    }

    public double getFirstPrice() {
        return Double.parseDouble(
                page.locator(".inventory_item_price").nth(0).innerText().replace("$", "")
        );
    }

    public double getSecondPrice() {
        return Double.parseDouble(
                page.locator(".inventory_item_price").nth(1).innerText().replace("$", "")
        );
    }

    public void addTopTwo() {
        page.locator(".btn_inventory").nth(0).click();
        page.locator(".btn_inventory").nth(1).click();
    }
}