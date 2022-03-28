package shoopingCart.domain;

public class Product {
    private String productName;
    private Price productPrice;
    private Integer productWeight;

    public Product(String productName, Price productPrice, Integer productWeight) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productWeight = productWeight;
    }

    public Integer getProductWeight() {
        return productWeight;
    }

    public String getProductName() {
        return productName;
    }

    public Price getProductPrice() {
        return productPrice;
    }
}
