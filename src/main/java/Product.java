public class Product {
    private String productName;
    private Double productPrice;

    public Product(String productName, Double productPrice) {

        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }
}
