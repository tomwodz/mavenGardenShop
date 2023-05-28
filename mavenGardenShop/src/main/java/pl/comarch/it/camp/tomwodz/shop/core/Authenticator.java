package pl.comarch.it.camp.tomwodz.shop.core;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.comarch.it.camp.tomwodz.shop.GUI.IGUI;
import pl.comarch.it.camp.tomwodz.shop.db.IUserRepository;
import pl.comarch.it.camp.tomwodz.shop.model.User;

@Component
public class Authenticator implements IAuthenticator{

    @Autowired
    private IGUI gui;

    @Autowired
    private IUserRepository usersDataBase;

    private static final String seed = "uxU9xUQWQMbZQm6rmtHd";

    public String authenticate() {
        int counter = 0;
        while (counter < 3) {
            User userFromGUI = gui.readLoginAndPassword();
            User userFromDb = usersDataBase.findUserByLogin(userFromGUI.getLogin());
            if (userFromDb != null && userFromDb.getPassword().equals(DigestUtils.md5Hex(userFromGUI.getPassword() + seed))) {
                System.out.println("Correct login!");
                return userFromDb.getRole();
            }
            System.out.println("Incorrect login and password! Try again!");
            counter++;
        }
        return "BRAK";
    }

    public void registration() {
        int counter =0;
        while (counter < 3) {
            User userFromGUI = gui.readLogin();
            User userFromDb = usersDataBase.findUserByLogin(userFromGUI.getLogin());
            if (userFromDb == null) {
                System.out.println("Login is free.");
                userFromGUI.setPassword(DigestUtils.md5Hex(gui.savePassword() + seed));
                userFromGUI.setName(gui.saveName());
                userFromGUI.setEmail(gui.saveEmail());
                usersDataBase.createNewUser(userFromGUI);
               break;
            } else {
                System.out.println("Login is busy. Try again.");
                counter++;
            }
        }
    }

    public void showUser() {
        System.out.println("Login: / Role:");
        for (User aUser : usersDataBase.getUser()) {
            if (aUser.isAvailable() != false) System.out.println(aUser);
        }
    }

    public void changeUserRole(User user) {
        for (User aUser : usersDataBase.getUser())
            if (aUser.getLogin().equals(user.getLogin()) && aUser.isAvailable() == true) {
                aUser.setRole(user.getRole());
                System.out.println("Success!");
            }
    }

}
