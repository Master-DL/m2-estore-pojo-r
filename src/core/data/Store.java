package core.data;

import java.util.*;

import core.data.interfaces.IItemList;
import core.data.interfaces.ISeller;
import core.service.BankService;
import estorePojo.exceptions.InsufficientBalanceException;
import estorePojo.exceptions.InvalidCartException;
import estorePojo.exceptions.UnknownAccountException;
import estorePojo.exceptions.UnknownItemException;

public class Store implements ISeller {

    private final ISeller provider;
    private IItemList itemStock;
    private Account account;

    private final Map<Product, Double> itemPrices = new HashMap<>();

    private Map<Integer, Order> storeOrders;

    /**
     * Constructs a new StoreImpl
     */
    public Store(ISeller prov, Account account) {
        provider = prov;
        account = account;
    }

    /**
     * A map of emitted orders.
     * keys = order keys as Integers
     * values = Order instances
     */
    private final Map<Integer, Order> orders = new HashMap<>();


    public ISeller getProvider() {
        return provider;
    }

    public Account getAccount() {
        return account;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    @Override
    public double getPrice(Product product) throws UnknownItemException {

        if (!itemPrices.containsKey(product))
            throw new UnknownItemException("Item " + product + " is not an item delivered by this provider.");

        Double price = itemPrices.get(product);
        return price.doubleValue();
    }

    public Map<Product, Integer> getItemsInStock() {
        return this.itemStock.getContent();
    }

    public Map<Integer, Order> getStoreOrders() {
        return storeOrders;
    }
}
