package ui;

import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

import static org.testng.Assert.*;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCompleteFlow() {

        LoginPage login = new LoginPage(page);
        InventoryPage inventory = new InventoryPage(page);
        CartPage cart = new CartPage(page);
        CheckoutPage checkout = new CheckoutPage(page);

        login.login("standard_user", "secret_sauce");

        inventory.sortHighToLow();

        double first = inventory.getFirstPrice();
        double second = inventory.getSecondPrice();

        assertTrue(first >= second);

        inventory.addTopTwo();

        cart.checkout();

        checkout.completeOrder();

        assertEquals(checkout.getConfirmation(), "Thank you for your order!");
    }
}