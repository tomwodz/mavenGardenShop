package pl.comarch.it.camp.tomwodz.shop.db;

import pl.comarch.it.camp.tomwodz.shop.model.User;

import java.util.Collection;

public interface IUserRepository {
    Collection<User> getUser();

    User findUserByLogin(String login);

    void createNewUser(User user);

    void addUser(User user);
}
