package shoopingCart.account;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {
    @Test
    void updateTheAccountAddressWhenCustomerAddressIsUpdated() {
        Address address = new Address("Chennai");
        Account account = new Account("1", address);
        Customer customer = new Customer("1", Arrays.asList(account), address);

        Address newAddress = new Address("Kerala");
        customer.setNewAddress(newAddress);
        Address updatedAccountAdress = account.getAddress();

        assertEquals(updatedAccountAdress.getCity(), "Kerala");
    }

}