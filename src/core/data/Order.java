package core.data;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import core.Client;
import core.service.OrderService;
import estorePojo.exceptions.UnknownItemException;

public class Order {

	/** The total number of orders emitted so far. */
	private static int numOrders;

	/** The index of this order. */
	private int num;

	private Client client;
	private Object item;
	private String address;
	private String bankAccountRef;

	/** The date at which the ordered is issued. */
	public Date date;

	/** The delay for delivering the items in the order. */
	private int delay;

	/** The items currently in the order. */
	private Set<Object> items = new HashSet<>();

	/** The quantities of each item ordered. key=item, value=quantity. */
	private Map<Object,Integer> itemQuantities = new HashMap<>();

	/** The individual prices of each item ordered. key=item, value=price. */
	private Map<Object,Double> itemPrices = new HashMap<>();

	private Order() {
		num = numOrders++;
		date = new Date();
	}

	public Order(Client client, String address, String bankAccountRef) {
		this();
		this.client = client;
		this.address = address;
		this.bankAccountRef = bankAccountRef;
	}

	/**
	 * @return Returns the delay for delivering this order.
	 */
	public int getDelay() {
		return delay;
	}

	/**
	 * Set the delay for this order. The delay is the highest delay for delivering
	 * all the items of an order.
	 */
	public void setDelay(int delay) {
		if (delay > this.delay)
			this.delay = delay;
	}

	public int getKey() {
		return num;
	}

	public Set<Object> getItems() {
		return items;
	}

	public void setItems(Set<Object> items) {
		this.items = items;
	}

	public Map<Object, Integer> getItemQuantities() {
		return itemQuantities;
	}

	public void setItemQuantities(Map<Object, Integer> itemQuantities) {
		this.itemQuantities = itemQuantities;
	}

	public Map<Object, Double> getItemPrices() {
		return itemPrices;
	}

	public void setItemPrices(Map<Object, Double> itemPrices) {
		this.itemPrices = itemPrices;
	}

	public String toString() {
		String msg = "Order #" + num + " ";
		msg += "amount: " + new OrderService().computeAmount(this) + " "; //todo : pb de couplage, à changer
		msg += "delay: " + getDelay() + "h ";
		msg += "issued on: " + date;
		return msg;
	}
}
