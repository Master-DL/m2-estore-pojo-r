package core.data;

import java.util.HashMap;
import java.util.Map;

import core.data.interfaces.ISeller;
import estorePojo.exceptions.UnknownItemException;

public class Provider implements ISeller {

	private final Map<Product, Double> itemPrices = new HashMap<>();


	/**
	 * Get the price of an item provided by this provider.
	 * 
	 * @param product
	 * @return
	 */
	@Override
	public double getPrice(Product product) throws UnknownItemException {

		if (!itemPrices.containsKey(product))
			throw new UnknownItemException("Item " + product + " is not an item delivered by this provider.");

		Double price = itemPrices.get(product);
		return price.doubleValue();
	}

	public Map<Product, Double> getItemPrices() {
		return itemPrices;
	}
}
