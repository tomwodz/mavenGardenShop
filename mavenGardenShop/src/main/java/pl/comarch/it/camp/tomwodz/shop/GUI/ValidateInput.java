package pl.comarch.it.camp.tomwodz.shop.GUI;

import org.springframework.stereotype.Component;

@Component
public class ValidateInput implements IValidateInput{
    public boolean validateName(String name){
        return name.matches("[A-Z][a-zA-Z]*");
    }
}
