package core.service.interfaces;

import core.data.*;
import core.data.interfaces.IItemList;
import core.data.interfaces.ISeller;
import estorePojo.exceptions.InsufficientBalanceException;
import estorePojo.exceptions.InvalidCartException;
import estorePojo.exceptions.UnknownAccountException;
import estorePojo.exceptions.UnknownItemException;

import java.util.Date;

public interface ISellerService {
    Order order(Store store, Cart cart, String deliveryAddress, Account clientAccount, Date deliveryDate, int deliveryDelay) throws InvalidCartException, UnknownItemException, InsufficientBalanceException, UnknownAccountException;
}
