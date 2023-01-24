package core.data;

import core.data.interfaces.IItemList;

import java.util.Map;

public class ItemStock implements IItemList {
    Map<Product, Integer> itemStock;
    @Override
    public Map<Product, Integer> getContent() {
        return itemStock;
    }
}
