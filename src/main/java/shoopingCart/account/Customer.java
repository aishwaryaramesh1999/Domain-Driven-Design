package shoopingCart.account;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String id;
    private List<Account> listOfAccount = new ArrayList<>();
    private Address address;

    public Customer(String id, List<Account> listOfAccount, Address address) {
        this.id = id;
        this.address = address;
        this.listOfAccount = listOfAccount;
    }

    public void setNewAddress(Address newAddress) {
        this.address = newAddress;
        for (Account accountList : listOfAccount) {
            accountList.updateAddress(newAddress);
        }
    }
}
