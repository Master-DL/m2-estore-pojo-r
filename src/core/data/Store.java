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
	     * @param item  a given item
	     * @return      the price of a given item
	     * @throws UnknownItemException
	     */
	    public double getPrice( Object item ) throws UnknownItemException {
	        return provider.getPrice(item);
	    }
	    


	    /**
	     * A map of emitted orders.
	     * keys = order keys as Integers
	     * values = Order instances
	     */
	    private Map<Integer,Order> orders = new HashMap<>();
	    
	    /** 
	     * A map of items available in the stock of the store.
	     * keys = the references of the items as Objects
	     * values = ItemInStock instances
	     */
	    private Map<Object,ItemInStock> itemsInStock = new HashMap<>();


	    
	    /**
	     * Treat an item ordered by a client and update the corresponding order.
	     * 
	     * @param order 
	     * @param item
	     * @param qty
	     * @return
	     * 
	     * @throws UnknownItemException
	     * @throws InsufficientBalanceException
	     * @throws UnknownAccountException
	     */
	    private void treatOrder( Order order, Object item, int qty )
	    throws UnknownItemException {
	        
	        // The number of additional item to order
	        // in case we need to place an order to the provider
	        final int more = 10;
	        
	        // The price of the ordered item
	        // Throws UnknownItemException if the item does not exist
	        final double price = provider.getPrice(item);
	        
	        final double totalAmount = price*qty;
	        
	        // The delay (in hours) for delivering the order
	        // By default, it takes 2 hours to ship items from the stock
	        // This delay increases if an order is to be placed to the provider
	        int delay = 2;
	        
	        // Check whether the item is available in the stock
	        // If not, place an order for it to the provider
	        ItemInStock iis = (ItemInStock) itemsInStock.get(item);
	        if ( iis == null ) {
	            int quantity = qty + more;
	            delay += provider.order(this,item,quantity);
	            ItemInStock newItem = new ItemInStock(item,more,price,provider);
	            itemsInStock.put(item,newItem);
	        }
	        else {
	            // The item is in the stock
	            // Check whether there is a sufficient number of them
	            // to match the order
	            if ( iis.getQuantity() >= qty ) {
	                iis.changeQuantity(qty);
	            }
	            else {
	                // An order to the provider needs to be issued
	                int quantity = qty + more;
	                delay += provider.order(this,item,quantity);
	                iis.changeQuantity(more);
	            }
	        }
	        
	        // Update the order
	        order.addItem(item,qty,price);
	        order.setDelay(delay);
	    }

	    // -----------------------------------------------------
	    // Other methods
	    // -----------------------------------------------------
	    
	    public String toString() {
	       return "E-Store"; 
	    }
	}
