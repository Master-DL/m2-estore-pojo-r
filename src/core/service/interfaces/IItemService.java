package core.service.interfaces;

import core.data.Product;
import core.data.interfaces.IItemList;
import core.data.interfaces.ISeller;

import java.util.Map;

public interface IItemService {

    void addItem(Product product, int quantity, IItemList itemsContent);

    void setQuantity(Product product, int quantity, IItemList itemsContent);

    double computeAmount(IItemList itemsContent, ISeller store);
}
