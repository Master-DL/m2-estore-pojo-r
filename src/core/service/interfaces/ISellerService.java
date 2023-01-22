package core.service.interfaces;

import core.data.Account;
import core.data.Cart;
import core.data.Product;
import core.data.interfaces.ISeller;

public interface ISellerService {
    void pay(ISeller seller, Cart cart, String address, Account account);
    void order(ISeller provider, ISeller store, Product product, int quantity);
}
