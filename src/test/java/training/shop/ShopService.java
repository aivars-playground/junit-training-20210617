package training.shop;

import training.shop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ShopService {
    final List<Product> products;

    public ShopService() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
