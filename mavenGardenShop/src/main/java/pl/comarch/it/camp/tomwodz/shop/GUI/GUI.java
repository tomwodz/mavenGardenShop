package pl.comarch.it.camp.tomwodz.shop.GUI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.comarch.it.camp.tomwodz.shop.db.IUserRepository;
import pl.comarch.it.camp.tomwodz.shop.model.User;
import pl.comarch.it.camp.tomwodz.shop.product.Product;

import java.util.EnumSet;
import java.util.Scanner;
@Component
public  class GUI implements IGUI {

    @Autowired
    private ValidateInput validateInput;
    @Autowired
    private IUserRepository userRepository;

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
        String name = "To be completed.";
        int counter = 0;
        do {
            name = scanner.nextLine().trim();
            if (validateInput.validateName(name)) {
            run = false;
            }
            else {System.out.println("Enter only letters.");
                counter++;
                name = "To be completed.";
            };
        } while (run && counter<3);
        return name;
    }

    public  String saveEmail(){
        System.out.println("Please give your e-mail: ");
        return scanner.nextLine().trim();
    }

    public  Product buyProduct(){
        Product product = new Product();
        System.out.println("Enter the product code:");
        product.setCode(scanner.nextLine());
        System.out.println("Enter quantity:");
        product.setQuantity(Integer.parseInt(scanner.nextLine()));
        return product;
    }

    public  Product exchangeProduct(){
        Product product = new Product();
        System.out.println("Enter the product code:");
        product.setCode(scanner.nextLine());
        System.out.println("Enter quantity:");
        product.setQuantity(Integer.parseInt(scanner.nextLine()));
        return product;
    }

    public User readLoginChangeUser() {
        User user = new User();
        System.out.println("Please give login user for change: ");
        boolean run = true;
        int counter = 0;
        while (run && counter <3) {
            String login = scanner.nextLine();
            for (User AUser : userRepository.getUser().values()) {
                if (login.equals(AUser.getLogin())) {
                    user.setLogin(login);
                    user.setRole(AUser.getRole());
                    run = false;
                    boolean run2 = true;
                    int counter2 = 0;
                    while (run2 && counter2 < 3) {
                        System.out.println("Please give new role (USER or ADMIN): ");
                        String role = scanner.nextLine();
                        if (role.equals("ADMIN") || role.equals("USER")) {
                            user.setRole(role);
                            run2 = false;
                        } else {
                            counter2++;
                            if(counter2>3){
                                return user;
                            }
                        }
                    }
                }
            }
            counter++;
            if(counter<3 && run) {
                System.out.println("Please give correct login: ");

            }
            else {break;}
        }
        return user;
    }
}
