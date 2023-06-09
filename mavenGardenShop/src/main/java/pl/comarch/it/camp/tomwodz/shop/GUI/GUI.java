package pl.comarch.it.camp.tomwodz.shop.GUI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.comarch.it.camp.tomwodz.shop.core.ICore;
import pl.comarch.it.camp.tomwodz.shop.db.IUserRepository;
import pl.comarch.it.camp.tomwodz.shop.model.User;
import pl.comarch.it.camp.tomwodz.shop.product.Product;

import java.util.EnumSet;
import java.util.Scanner;
@Component
public  class GUI implements IGUI {

    @Autowired
    private IValidateInput validateInput;
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ICore core;

    Scanner scanner = new Scanner(System.in);
    @Override
    public String showMenu(){
        for(Menu menu: EnumSet.range(Menu.HEADMENU1, Menu.HEADMENU4)){
            System.out.println(menu);}
        return scanner.nextLine().trim();
    }
    @Override
    public String showMenuUser(String userRole){
        if(userRole.equals("ADMIN")) {
            for (Menu menu : EnumSet.range(Menu.USERMENU1, Menu.ADMINMENU2)) {
                System.out.println(menu);
            }}
        else if (userRole.equals("USER")) {
                for (Menu menu : EnumSet.range(Menu.USERMENU1, Menu.USERMENU4)) {
                    System.out.println(menu);
                }
            }
        return scanner.nextLine().trim();
    }
    @Override
    public  User readLoginAndPassword(){
        System.out.println("Please give your login: ");
        String login = scanner.nextLine().trim();
        System.out.println("Please give your password: ");
        return new User(login, scanner.nextLine().trim());
    }
    @Override
    public  User readLogin(){
        System.out.println("Please give your login: ");
        return new User(scanner.nextLine().trim());
    }
    @Override
    public  String savePassword(){
        System.out.println("Please give your password: ");
        return scanner.nextLine().trim();
    }
    @Override
    public String saveName(){
        System.out.println("Please give your name: ");
        return saveAName(scanner.nextLine().trim());
    }
    private String saveAName(String name) {
        if (validateInput.validateName(name)) {
            return name;
        } else if (name.equals("0")) {
            core.start();
        } else {
            System.out.println("Please give your name - only letters, first big (write 0 to break): ");}
            return saveAName(scanner.nextLine().trim());
    }

    @Override
    public  String saveEmail(){
        System.out.println("Please give your e-mail: ");
        return scanner.nextLine().trim();
    }
    @Override
    public  Product buyProduct(){
        Product product = new Product();
        return buyAProduct(product);
    }

    private Product buyAProduct(Product product){
        Product aProduct = product;
        System.out.println("Enter the product code:");
        String code = scanner.nextLine().trim();
        if (validateInput.validateCode(code)) {
            aProduct.setCode(code);
            System.out.println("Enter quantity:");
            String quantity = scanner.nextLine().trim();
            if (validateInput.validateQuantity(quantity)) {
                aProduct.setQuantity(Integer.parseInt(quantity));
                return aProduct;
            }
            else {buyAProduct(aProduct);};
        }
        else {buyAProduct(product);}
        return aProduct;
    }

    @Override
    public  Product exchangeProduct(){
        Product product = new Product();
        System.out.println("Enter the product code:");
        product.setCode(scanner.nextLine());
        System.out.println("Enter quantity:");
        product.setQuantity(Integer.parseInt(scanner.nextLine()));
        return product;
    }

    @Override
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
