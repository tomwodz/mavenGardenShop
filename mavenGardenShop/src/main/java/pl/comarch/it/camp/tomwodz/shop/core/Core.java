package pl.comarch.it.camp.tomwodz.shop.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.comarch.it.camp.tomwodz.shop.GUI.IGUI;
import pl.comarch.it.camp.tomwodz.shop.db.IFileLoader;
import pl.comarch.it.camp.tomwodz.shop.db.IProductRepository;

import java.io.IOException;

@Component
public class Core implements ICore {
    @Autowired
    private IFileLoader fileLoader;

    @Autowired
    private IAuthenticator authenticator;

    @Autowired
    private IProductRepository productsDataBase;
    @Autowired
    private IGUI gui;

   @Override
    public void start() {
        try {
            fileLoader.readDataFromFile();
        } catch (IOException e) {
            System.out.println("Database is malformed !!");
            return;
        }

        while (true) {
            switch (gui.showMenu()) {
                case "1":
                    boolean runMenuUser = true;
                    String userRole = authenticator.authenticate();
                    if (userRole.equals("ADMIN") || userRole.equals("USER")) {
                        while (runMenuUser) {
                            switch (gui.showMenuUser(userRole)) {
                                case "1":
                                    productsDataBase.showProducts(userRole);
                                    break;
                                case "2":
                                    productsDataBase.buyProducts(gui.buyProduct());
                                    break;
                                case "3":
                                    runMenuUser = false;
                                    System.out.println("Correct logout!");
                                    break;
                                case "4":
                                    if (userRole.equals("ADMIN")) {
                                        productsDataBase.exchangeProducts(gui.exchangeProduct());
                                    }
                                    break;
                                case "5":
                                    if (userRole.equals("ADMIN")) {
                                        authenticator.showUser();
                                        authenticator.changeUserRole(gui.readLoginChangeUser());
                                    }
                                    break;
                                default:
                                    System.out.println("Wrong choose!!");
                                    break;
                            }
                        }
                    }
                    break;
                case "2":
                    authenticator.registration();
                    break;
                case "3":
                    try {
                        fileLoader.saveDataToFile();
                    } catch (IOException e) {
                        System.out.println("Error database!! Please contact with admin");
                    }
                    System.out.println("Thank you for using our GardenShop! See you later!");
                    return;
                default:
                    System.out.println("Wrong choose!!");
                    break;
            }
        }
    }

}