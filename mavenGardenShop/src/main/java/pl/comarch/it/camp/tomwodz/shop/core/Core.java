package pl.comarch.it.camp.tomwodz.shop.core;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.comarch.it.camp.tomwodz.shop.GUI.IGUI;
import pl.comarch.it.camp.tomwodz.shop.db.FileLoader;
import pl.comarch.it.camp.tomwodz.shop.db.IProductRepository;

import java.io.IOException;
@Component
public class Core {
    @Autowired
    private FileLoader fileLoader;

    @Autowired
    private IAuthenticator authenticator;

    @Autowired
    private IProductRepository productsDataBase;
    @Autowired
    private IGUI gui;
    public void start() {
       try {
            fileLoader.readDataFromFile();
        } catch (IOException e) {
            System.out.println("Database is malformed !!");
            return;
        }

        while (true) {
            switch (gui.showMenu()) {
                case 1:
                    boolean runMenuUser = true;
                    String userRole = authenticator.authenticate();
                    if(userRole.equals("ADMIN")  || userRole.equals("USER")) {
                        while (runMenuUser) {
                            switch (gui.showMenuUser(userRole)) {
                                case 1:
                                    productsDataBase.showProduct(userRole);
                                    break;
                                case 2:
                                    System.out.println(productsDataBase.buyProducts(gui.buyProduct()));
                                    break;
                                case 3:
                                    runMenuUser = false;
                                    System.out.println("Correct logout!");
                                    break;
                                case 4:
                                    if (userRole.equals("ADMIN")) {
                                        productsDataBase.exchangeProducts(gui.exchangeProduct());
                                    }
                                    break;
                                case 5:
                                    if (userRole.equals("ADMIN")) {
                                        authenticator.showUser();
                                        authenticator.changeUserRole(gui.readLoginChangeUser());
                                    }
                                    break;
                                default:
                            }
                        }
                    }
                    break;
                case 2:
                    authenticator.registration();
                    break;
                case 3:
                    System.out.println("Waiting...");
                    try {
                     fileLoader.saveDataToFile();
                    }
                    catch(IOException e){
                        System.out.println("Error database!! Please contact with admin");
                    }
                    System.out.println("Thank you for using our GardenShop! See you later!");
                    return;
                default:
            }
        }
    }

}