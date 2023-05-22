package pl.comarch.it.camp.tomwodz.shop.core;

import pl.comarch.it.camp.tomwodz.shop.model.User;

public interface IAuthenticator {
    String authenticate();

    void registration();

    void showUser();

    void changeUserRole(User user);

}
