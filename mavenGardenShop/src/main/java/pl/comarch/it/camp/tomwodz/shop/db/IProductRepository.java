package pl.comarch.it.camp.tomwodz.shop.db;

import pl.comarch.it.camp.tomwodz.shop.product.Product;

import java.text.NumberFormat;
import java.util.Collection;

public interface IProductRepository {
    Collection<Product> getProducts();

    void buyProducts(Product product);

    void exchangeProducts(Product product);

    void showProduct(String userRole);

    void addProduct(Product product);
}
