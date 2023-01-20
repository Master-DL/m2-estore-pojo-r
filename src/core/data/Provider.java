package core.data;

import java.util.HashMap;
import java.util.Map;

import estorePojo.exceptions.UnknownItemException;

public class Provider {

	private Map<String, Double> itemPrices = new HashMap<>();

	/**
	 * Constructs a new ProviderImpl
	 */
	public Provider() {
		itemPrices.put("CD", 15d);
		itemPrices.put("DVD", 20d);
	}

	/**
	 * Get the price of an item provided by this provider.
	 * 
	 * @param item
	 * @return
	 */
	public double getPrice(Object item) throws UnknownItemException {

		if (!itemPrices.containsKey(item))
			throw new UnknownItemException("Item " + item + " is not an item delivered by this provider.");

		Double price = (Double) itemPrices.get(item);
		return price.doubleValue();
	}

	public Map<String, Double> getItemPrices() {
		return itemPrices;
	}
}
