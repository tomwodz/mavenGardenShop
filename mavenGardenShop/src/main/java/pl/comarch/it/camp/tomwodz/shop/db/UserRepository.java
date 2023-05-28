package pl.comarch.it.camp.tomwodz.shop.db;

import org.springframework.stereotype.Component;
import pl.comarch.it.camp.tomwodz.shop.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Component
public class UserRepository implements IUserRepository {
    private Map<String, User> users = new HashMap<>();

    public Collection<User> getUser() {
        return this.users.values();
    }

    public User findUserByLogin(String login) {
        return this.users.get(login);
    }

    public void createNewUser(User user) {
        this.users.put(user.getLogin(), new User(user.getLogin(), user.getPassword(), "USER", user.getName(), user.getEmail(), true));
        System.out.println("Success. Uzytkownik zostal utworzony.");
    }

    public void addUser(User user) {
        this.users.put(user.getLogin(), user);
    }

}
