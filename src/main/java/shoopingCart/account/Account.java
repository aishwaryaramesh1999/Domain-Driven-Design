package shoopingCart.account;

public class Account {
    private String id;
    private Address address;

    public Account(String id, Address address) {
        this.id = id;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void updateAddress(Address address) {
        this.address = address;
    }
}
