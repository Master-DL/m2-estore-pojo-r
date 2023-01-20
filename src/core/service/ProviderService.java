package core.service;

import core.data.Provider;
import core.data.Store;
import estorePojo.exceptions.UnknownItemException;

public class ProviderService {

    /**
     * Emit an order for items. The provider returns the delay for delivering the
     * items.
     *
     * @param store the store that emits the order
     * @param item  the item ordered
     * @param qty   the quantity ordered
     * @return the delay (in hours)
     */
    public int order(Provider provider, Store store, Object item, int qty) throws UnknownItemException {

        if (!provider.getItemPrices().containsKey(item))
            throw new UnknownItemException("Item " + item + " is not an item delivered by this provider.");

        // Actually the production process is quite chaotic
        // We only know that the production a random number of hours!!
        double r = Math.random() * 10 * qty;
        return (int) r;
    }
}
