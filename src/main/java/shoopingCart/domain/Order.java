package shoopingCart.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static List<Product> productList = new ArrayList<>();

    public Order(List<Product> productList) {
        this.productList = productList;
    }

    public static Double getTotalAmount() {
        Double totalAmount = 0.0;
        for (Product product : productList) {
            totalAmount = totalAmount + (product.getProductPrice().getAmount() + (product.getProductWeight() * 0.01));
        }
        return totalAmount;
    }
}
