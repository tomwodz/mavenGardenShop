package pl.comarch.it.camp.tomwodz.shop.db;

import pl.comarch.it.camp.tomwodz.shop.product.Product;

import java.text.NumberFormat;
import java.util.Collection;
import java.util.Map;

public interface IProductRepository {
    Map<String, Product> getProducts();

    void buyProducts(Product product);

    void exchangeProducts(Product product);

    void showProducts(String userRole);

    void addProduct(Product product);
}
