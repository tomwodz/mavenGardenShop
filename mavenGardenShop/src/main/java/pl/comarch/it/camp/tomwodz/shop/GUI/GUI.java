package pl.comarch.it.camp.tomwodz.shop.GUI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.comarch.it.camp.tomwodz.shop.model.User;
import pl.comarch.it.camp.tomwodz.shop.product.Product;

import java.util.EnumSet;
import java.util.Scanner;
@Component
public  class GUI implements IGUI {

    @Autowired
    ValidateInput validateInput;
    Scanner scanner = new Scanner(System.in);
    public  int showMenu(){
        for(Menu menu: EnumSet.range(Menu.HEADMENU1, Menu.HEADMENU4)){
            System.out.println(menu);}
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public int showMenuUser(String userRole){
        if(userRole.equals("ADMIN")) {
            for (Menu menu : EnumSet.range(Menu.USERMENU1, Menu.ADMINMENU2)) {
                System.out.println(menu);
            }}
        else if (userRole.equals("USER")) {
                for (Menu menu : EnumSet.range(Menu.USERMENU1, Menu.USERMENU4)) {
                    System.out.println(menu);
                }
            }
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public  User readLoginAndPassword(){
        System.out.println("Please give your login: ");
        String login = scanner.nextLine().trim();
        System.out.println("Please give your password: ");
        return new User(login, scanner.nextLine().trim());
    }

    public  User readLogin(){
        System.out.println("Please give your login: ");
        return new User(scanner.nextLine().trim());
    }
    public  String savePassword(){
        System.out.println("Please give your password: ");
        return scanner.nextLine().trim();
    }

    public  String saveName(){
        System.out.println("Please give your name: ");
        boolean run = true;
        String name;
        do {
            name = scanner.nextLine().trim();
            if (validateInput.validateName(name)) {
            run = false;
            }
            else {System.out.println("Imie składa się z samych liter. Wprowadz ponownie.");
            };
        } while (run);
        return name;
    }

    public  String saveEmail(){
        System.out.println("Please give your e-mail: ");
        return scanner.nextLine().trim();
    }

    public  Product buyProduct(){
        Product product = new Product();
        System.out.println("Podaj kod produktu, ktory chcesz kupic:");
        product.setCode(scanner.nextLine());
        System.out.println("Podaj ilosc produktu, ktora chcesz kupic:");
        product.setQuantity(Integer.parseInt(scanner.nextLine()));
        return product;
    }

    public  Product exchangeProduct(){
        Product product = new Product();
        System.out.println("Podaj kod produktu, ktory chcesz zmienic:");
        product.setCode(scanner.nextLine());
        System.out.println("Podaj ilosc produktu, ktora chcesz zmienc:");
        product.setQuantity(Integer.parseInt(scanner.nextLine()));
        return product;
    }

    public User readLoginChangeUser(){
        User user = new User();
        System.out.println("Please give login user for change: ");
        user.setLogin(scanner.nextLine());
        System.out.println("Please give new role: ");
        user.setRole(scanner.nextLine());
        return user;
    }
}
