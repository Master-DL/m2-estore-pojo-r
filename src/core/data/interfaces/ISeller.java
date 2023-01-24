package core.data.interfaces;

import core.data.Product;
import estorePojo.exceptions.UnknownItemException;

public interface ISeller {
    double getPrice(Product product) throws UnknownItemException;
}