package core.data;

import core.Client;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    
    /** The client owning the cart. */
    private final Client client;
    
    /** The items currently added to the cart. key=item, value=quantity. */
    private Map<Object,Integer> items = new HashMap<>();
    
    
    public Cart(Client client) {
        this.client = client;
    }
    
    public Map getItems() {
        return items;
    }

	public Client getClient() {
		return client;
	}
}
