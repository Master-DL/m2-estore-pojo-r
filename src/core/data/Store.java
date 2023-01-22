package core.data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import core.Client;
import core.service.BankService;
import estorePojo.exceptions.InsufficientBalanceException;
import estorePojo.exceptions.InvalidCartException;
import estorePojo.exceptions.UnknownAccountException;
import estorePojo.exceptions.UnknownItemException;

public class Store {

    private Provider provider;
    private BankService bank;

    /**
     * Constructs a new StoreImpl
     */
    public Store(Provider prov, BankService bk) {
        provider = prov;
        bank = bk;
    }

    /**
     * @param item a given item
     * @return the price of a given item
     * @throws UnknownItemException
     */
    public double getPrice(Object item) throws UnknownItemException {
        return provider.getPrice(item);
    }

    /**
     * A map of emitted orders.
     * keys = order keys as Integers
     * values = Order instances
     */
    private Map<Integer, Order> orders = new HashMap<>();

    /**
     * A map of items available in the stock of the store.
     * keys = the references of the items as Objects
     * values = ItemInStock instances
     */
    private Map<Object, ItemInStock> itemsInStock = new HashMap<>();

    public Provider getProvider() {
        return provider;
    }

    public BankService getBank() {
        return bank;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    public Map<Object, ItemInStock> getItemsInStock() {
        return itemsInStock;
    }

    // -----------------------------------------------------
    // Other methods
    // -----------------------------------------------------

    public String toString() {
        return "E-Store";
    }
}
