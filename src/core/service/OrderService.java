package core.service;

import core.data.Order;
import estorePojo.exceptions.UnknownItemException;

public class OrderService {

    /**
     * Add an item to the order.
     *
     * @param item
     * @param qty
     * @param price
     * @throws UnknownItemException
     */
    public void addItem(Order order, Object item, int qty, double price) throws UnknownItemException {

        if (order.getItemPrices().containsKey(item)) {
            double oldPrice = ((Double) order.getItemPrices().get(item)).doubleValue();
            if (oldPrice != price)
                throw new UnknownItemException(
                        "Item " + item + " price (" + price + ") added to cart is different from the price (" + oldPrice
                                + ") of the same item already in the cart");
        }

        order.getItems().add(item);
        order.getItemPrices().put(item, price);

        int newQty = qty;
        if (order.getItemQuantities().containsKey(item)) {
            newQty += ((Integer) order.getItemQuantities().get(item)).intValue();
        }
        order.getItemQuantities().put(item, newQty);
    }

    /**
     * Compute the total amount of the order
     */
    public double computeAmount(Order order) {

        double amount = 0;

        for (Object item : order.getItems()) {
            int qty = ((Integer) order.getItemQuantities().get(item)).intValue();
            double price = ((Double) order.getItemPrices().get(item)).doubleValue();
            amount += qty * price;
        }

        return amount;
    }
}
