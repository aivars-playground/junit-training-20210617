package training.shop;

import training.shop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ShopService {
    final List<Product> products;
    final SupplierService supplier;

    public ShopService(SupplierService supplier) {
        this.supplier = supplier;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean canBuyProduct(Product product) {
        return supplier.sells(product);
    }
}
