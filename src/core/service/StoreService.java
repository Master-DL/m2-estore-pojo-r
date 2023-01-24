package core.service;

import core.data.*;
import core.service.interfaces.IBankService;
import core.service.interfaces.IItemService;
import core.service.interfaces.ISellerService;
import estorePojo.exceptions.InsufficientBalanceException;
import estorePojo.exceptions.InvalidCartException;
import estorePojo.exceptions.UnknownAccountException;
import estorePojo.exceptions.UnknownItemException;

import java.util.Date;

public class StoreService implements ISellerService {

    private final IItemService cartService;
    private final IItemService orderService;

    private final IBankService bankService;

    public StoreService() {
        cartService = new CartService();
        orderService = new OrderService();
        bankService = new BankService();
    }

    /**
     * @param product  a given product
     * @param qty   a given quantity
     * @return
     *      true if the given quantity of the given item is available
     *      directly from the store
     *      i.e. without having to re-order it from the provider
     */
    public boolean isAvailable(Store store, Product product, int qty )
            throws UnknownItemException {

        return store.getItemsInStock().containsKey(product) && store.getItemsInStock().get(product) >= qty;
    }

    @Override
    public Order order(Store store, Cart cart, String deliveryAddress, Account clientAccount, Date deliveryDate, int deliveryDelay) throws InvalidCartException, UnknownItemException, InsufficientBalanceException, UnknownAccountException {
        double cartTotal = cartService.computeAmount(cart, store);
        bankService.trasnfert(clientAccount, store.getAccount(), cartTotal);
        Order order = new Order(clientAccount, deliveryAddress, store, deliveryDate, deliveryDelay);
        order.setContent(cart.getCartContent());
        return order;
    }
}
