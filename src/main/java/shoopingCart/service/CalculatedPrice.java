package shoopingCart.service;

import shoopingCart.domain.Price;

import java.util.HashMap;

public class CalculatedPrice {
    private static HashMap<String, Price> productPriceMap = new HashMap<>();


    public static void setProductCompetatorPrice(String productName, Price price) {
        productPriceMap.put(productName, price);
    }

    public static Integer getProductPriceAfterDiscount(String productName) {
        Integer value = productPriceMap.get(productName).getAmount() - 10 / 100;
        return value;
    }

}
