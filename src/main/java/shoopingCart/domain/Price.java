package shoopingCart.domain;

public class Price {
    private Integer amount;
    private String currency;

    public Price(Integer amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

    public Price getPrice(){
        return new Price(this.amount,this.currency);
    }
    public Integer getAmount() {
        return amount;
    }
}
