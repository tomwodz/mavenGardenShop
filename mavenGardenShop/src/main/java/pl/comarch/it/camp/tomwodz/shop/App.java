package pl.comarch.it.camp.tomwodz.shop;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.comarch.it.camp.tomwodz.shop.cofiguration.AppConfiguration;
import pl.comarch.it.camp.tomwodz.shop.core.Core;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome in our GardenShop!");
        try {
            ApplicationContext box =
                    new AnnotationConfigApplicationContext(AppConfiguration.class);
        Core core = box.getBean(Core.class);
        core.start();
        }
        catch (BeansException e){
            System.out.println("Error !!");
        }
    }
}
