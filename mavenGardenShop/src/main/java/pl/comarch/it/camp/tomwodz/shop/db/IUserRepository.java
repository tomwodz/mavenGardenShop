package pl.comarch.it.camp.tomwodz.shop.db;

import pl.comarch.it.camp.tomwodz.shop.model.User;

import java.util.Map;

public interface IUserRepository {
    Map<String, User> getUser();

    User findUserByLogin(String login);

    void createNewUser(User user);

    void addUser(User user);
}
