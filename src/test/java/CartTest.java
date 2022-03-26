import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    @Test
    void addIPadProToCart() {
        Cart cart = new Cart();
        Product product = new Product("IPad Pro", 25.0);
        Item item = new Item(product, 1);

        boolean isItemAdded = cart.addItem(item);

        assertTrue(isItemAdded);
    }

    @Test
    void addHeroInkPenToCart() {
        Cart cart = new Cart();
        Product product = new Product("Hero Ink Pen", 26.0);
        Item item = new Item(product, 1);

        boolean isItemAdded = cart.addItem(item);

        assertTrue(isItemAdded);
    }

    @Test
    void addGmCricketBatToCart() {
        Cart cart = new Cart();
        Product product = new Product("GM Cricket Bat", 30.0);
        Item item = new Item(product, 2);

        boolean isItemAdded = cart.addItem(item);

        assertTrue(isItemAdded);
    }

    @Test
    void removeIpadPro() {
        Cart cart = new Cart();
        Product product = new Product("Ipad Pro", 25.0);
        Item item = new Item(product, 1);

        cart.addItem(item);
        boolean isItemRemoved = cart.removeItem(item);

        assertTrue(isItemRemoved);
    }

    @Test
    void getListOfDeletedItems() {
        Cart cart = new Cart();
        Product product1 = new Product("Ipad Pro", 25.0);
        Product product2 = new Product("Cricket Bat", 30.0);
        Item item1 = new Item(product1, 1);
        Item item2 = new Item(product2, 1);

        cart.addItem(item1);
        cart.addItem(item2);
        cart.removeItem(item2);
        List<Item> actualDeletedItemList = cart.getDeletedItem();
        List<Item> expectedDeletedItems = Arrays.asList(item2);

        assertEquals(actualDeletedItemList, expectedDeletedItems);
    }

    @Test
    void differentiateCart() {
        Cart cart1 = new Cart();
        Product product1 = new Product("IPad Pro", 25.0);
        Item item1 = new Item(product1, 1);

        Cart cart2 = new Cart();
        Product product2 = new Product("IPad Pro", 25.0);
        Item item2 = new Item(product2, 1);

        cart1.addItem(item1);
        cart2.addItem(item2);

        assertFalse(cart1.equals(cart2));
    }

    @Test
    void checkItemIsPresentOrNot() {
        Cart cart = new Cart();
        Product product = new Product("Ipad Pro", 25.0);
        Item item = new Item(product, 1);

        cart.addItem(item);

        List<Item> actualItemsInCart = cart.getItems();
        List<Item> expectedItemsInCart = Arrays.asList(item);

        assertEquals(actualItemsInCart, expectedItemsInCart);
    }
}