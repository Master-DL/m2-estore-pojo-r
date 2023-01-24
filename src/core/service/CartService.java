package core.service;

import core.data.Product;
import core.data.interfaces.IItemList;
import core.data.interfaces.ISeller;
import core.service.interfaces.IItemService;
import estorePojo.exceptions.UnknownItemException;

public class CartService implements IItemService {

    private final StoreService storeService;
    public CartService() {
        storeService = new StoreService();
    }

    @Override
    public void addItem(Product product, int quantity, IItemList itemsContent) {
        itemsContent.getContent().put(product, quantity);
    }

    @Override
    public void setQuantity(Product product, int quantity, IItemList itemsContent) {
        itemsContent.getContent().replace(product, quantity);
    }

    @Override
    public double computeAmount(IItemList itemsContent, ISeller store) {
        double total = 0;
        for(Product p : itemsContent.getContent().keySet()) {
            try {
                total += itemsContent.getContent().get(p) * store.getPrice(p);
            } catch (UnknownItemException e) {
                throw new RuntimeException(e);
            }
        }
        return total;
    }
}
