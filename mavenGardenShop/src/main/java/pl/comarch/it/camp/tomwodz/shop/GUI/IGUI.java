package pl.comarch.it.camp.tomwodz.shop.GUI;

import pl.comarch.it.camp.tomwodz.shop.model.User;
import pl.comarch.it.camp.tomwodz.shop.product.Product;

public interface IGUI {

    String showMenu();

   String showMenuUser(String userRole);

    User readLoginAndPassword();

     User readLogin();

    String savePassword();

    String saveName();

    String saveEmail();

    Product buyProduct();

    Product exchangeProduct();
    User readLoginChangeUser();
}
