package core.service;

import core.data.ItemInStock;

public class ItemInStockService {

    public void changeQuantity(ItemInStock item, int qtyToAddOrRemove) {
        if ((qtyToAddOrRemove >= 0 ) || (item.getQuantity() >= -qtyToAddOrRemove)) {
            item.setQuantity(item.getQuantity() + qtyToAddOrRemove);
        }
    }
}
