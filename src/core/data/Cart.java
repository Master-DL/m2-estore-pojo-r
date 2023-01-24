package core.data;

import core.Client;
import core.data.interfaces.IItemList;

import java.util.HashMap;
import java.util.Map;

public class Cart implements IItemList {
    
    /** The client owning the cart. */
    private final Client client;
    
    /** The items currently added to the cart. key=item, value=quantity. */
    private final Map<Product,Integer> cartContent = new HashMap<>();
    
    
    public Cart(Client client) {
        this.client = client;
    }
    
    public Map getCartContent() {
        return cartContent;
    }

	public Client getClient() {
		return client;
	}

    @Override
    public Map<Product, Integer> getContent() {
        return cartContent;
    }
}
