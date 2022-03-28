package shoopingCart.account;

import org.junit.jupiter.api.Test;
import shoopingCart.domain.Cart;
import shoopingCart.domain.Item;
import shoopingCart.domain.Price;
import shoopingCart.domain.Product;
import shoopingCart.service.CalculatedPrice;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    @Test
    void addIPadProToCart() {
        Cart cart = new Cart();
        Price price = new Price(25, "ERU");
        Product product = new Product("IPad Pro", price, 20);
        Item item = new Item(product, 1);

        boolean isItemAdded = cart.addItem(item);

        assertTrue(isItemAdded);
    }

    @Test
    void addHeroInkPenToCart() {
        Cart cart = new Cart();
        Price price = new Price(25, "ERU");
        Product product = new Product("Hero Ink Pen", price, 20);
        Item item = new Item(product, 1);

        boolean isItemAdded = cart.addItem(item);

        assertTrue(isItemAdded);
    }

    @Test
    void addGmCricketBatToCart() {
        Cart cart = new Cart();
        Price price = new Price(25, "ERU");
        Product product = new Product("GM Cricket Bat", price, 20);
        Item item = new Item(product, 2);

        boolean isItemAdded = cart.addItem(item);

        assertTrue(isItemAdded);
    }

    @Test
    void removeIpadPro() {
        Cart cart = new Cart();
        Price price = new Price(25, "ERU");
        Product product = new Product("IPad Pro", price, 20);
        Item item = new Item(product, 1);

        cart.addItem(item);
        boolean isItemRemoved = cart.removeItem(item);

        assertTrue(isItemRemoved);
    }

    @Test
    void getListOfDeletedItems() {
        Cart cart = new Cart();
        Price price1 = new Price(25, "ERU");
        Price price2 = new Price(25, "ERU");
        Product product1 = new Product("Ipad Pro", price1, 20);
        Product product2 = new Product("Cricket Bat", price2, 20);
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
        Price price1 = new Price(25, "ERU");
        Product product1 = new Product("IPad Pro", price1, 20);
        Item item1 = new Item(product1, 1);

        Cart cart2 = new Cart();
        Price price2 = new Price(25, "ERU");
        Product product2 = new Product("IPad Pro", price2, 20);
        Item item2 = new Item(product2, 1);

        cart1.addItem(item1);
        cart2.addItem(item2);

        assertFalse(cart1.equals(cart2));
    }

    @Test
    void checkItemIsPresentOrNot() {
        Cart cart = new Cart();
        Price price = new Price(25, "ERU");
        Product product = new Product("Ipad Pro", price, 20);
        Item item = new Item(product, 1);

        cart.addItem(item);

        List<Item> actualItemsInCart = cart.getItems();
        List<Item> expectedItemsInCart = Arrays.asList(item);

        assertEquals(actualItemsInCart, expectedItemsInCart);
    }

    @Test
    void addPriceToProduct() {
        Cart cart = new Cart();
        Price price = new Price(25, "ERU");
        Product product = new Product("Ipad Pro", price, 20);
        Item item = new Item(product, 1);

        cart.addItem(item);
        Price actualPrice = price.getPrice();

        assertEquals(price.getAmount(), actualPrice.getAmount());
    }

    @Test
    void setProductPriceBasedOnDiscount() {
        Cart cart = new Cart();
        CalculatedPrice.setProductCompetatorPrice("Speaker", new Price(1000, "ERU"));
        Integer priceValue = CalculatedPrice.getProductPriceAfterDiscount("Speaker");
        Price price = new Price(priceValue, "ERU");
        Product product = new Product("IPad Pro", price, 20);
        Item item = new Item(product, 1);

        cart.addItem(item);
    }

    @Test
    void orderItems() {
        Cart cart = new Cart();
        Price price = new Price(100, "ERU");
        Product product1 = new Product("IPad Pro", price, 20);
        Item item1 = new Item(product1, 1);
        Product product2 = new Product("IPad Pro", price, 20);
        Item item2 = new Item(product1, 1);

        List<Product> productList = Arrays.asList(product1, product2);
        cart.addItem(item1);
        cart.addItem(item2);
        Double totalAmount = cart.checkoutCart();

        //Total cost = cost of all products in order + (weightIngrams of each product *.01)
        assertEquals(totalAmount, 200.4);

    }
}