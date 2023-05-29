package pl.comarch.it.camp.tomwodz.shop.db;

import org.springframework.stereotype.Component;
import pl.comarch.it.camp.tomwodz.shop.model.User;

import java.util.HashMap;
import java.util.Map;
@Component
public class UserRepository implements IUserRepository {
    private Map<String, User> users = new HashMap<>();
    @Override
    public Map<String, User>  getUser() {
        return users;
    }
    @Override
    public User findUserByLogin(String login) {
        return this.users.get(login);
    }
    @Override
    public void createNewUser(User user) {
        this.users.put(user.getLogin(), new User(user.getLogin(), user.getPassword(), "USER", user.getName(), user.getEmail(), true));
        System.out.println("Success. User created.");
    }
    @Override
    public void addUser(User user) {
        this.users.put(user.getLogin(), user);
    }

}
