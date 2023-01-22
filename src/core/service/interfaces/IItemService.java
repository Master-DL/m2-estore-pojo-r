package core.service.interfaces;

import core.data.Product;

public interface IItemService {
    void addItem(Product product, int quantity, double price);
    void setQuantity(Product product, int quantity);
    double computeAmount(Product product);
}
