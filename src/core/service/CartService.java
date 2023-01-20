package core.service;

import core.data.Cart;

public class CartService {

    public void addItem(Cart cart, Object item, int qty ) {
        int oldQty = 0;
        if ( cart.getItems().containsKey(item) ) {
            // The item has already been put in the cart
            // Increase the number
            oldQty = ((Integer) cart.getItems().get(item)).intValue();
        }
        cart.getItems().put( item, qty+oldQty );
    }

}
