package training.shop;

import training.shop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class SupplierService {

    private List<Product> availableProducts = new ArrayList<>();

    public boolean sells(Product product) {
        return availableProducts.contains(product);
    }
}
