package pl.comarch.it.camp.tomwodz.shop.db;

import org.springframework.stereotype.Component;
import pl.comarch.it.camp.tomwodz.shop.product.*;

import java.text.NumberFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProductRepository implements IProductRepository{

   private Map<String, Product> products = new HashMap<>();


    public Map<String, Product> getProducts() {
        return products;
    }

    public void buyProducts(Product product) {
        Product aProduct = this.products.get(product.getCode());
            try{
                if (product.getQuantity() <= aProduct.getQuantity()) {
                    aProduct.setQuantity(aProduct.getQuantity() - product.getQuantity());
                    System.out.println("Total price: ");
                    System.out.println(NumberFormat.getCurrencyInstance().format(product.getQuantity() * aProduct.getPricePerItem()));
                } else {
                    System.out.println(
                            new StringBuilder().append("Too much quantity.")
                            .append(" Max: ")
                            .append(aProduct.getQuantity())
                            .append(" for ")
                            .append(aProduct.getCode())
                            .append(" ")
                            .append(aProduct.getName())
                            .toString());
                }
            }
            catch (NullPointerException e){
                System.out.println("Wrong code.");
            }
    }

    public void exchangeProducts(Product product) {
        try {
            Product aProduct = this.products.get(product.getCode());
            aProduct.setQuantity(aProduct.getQuantity()+product.getQuantity());
        }
        catch (NullPointerException e){
            System.out.println("Wrong code.");
        }
    }

    public void showProduct(String userRole) {
        for (Product product : this.products.values()) {
            if (userRole.equals("ADMIN")) {
                    System.out.println(product);
            } else {
                if (product.getQuantity() != 0) {
                    System.out.println(product);
                }
            }
        }
    }

    public void addProduct(Product product) {
        this.products.put(product.getCode(), product);
    }

}
