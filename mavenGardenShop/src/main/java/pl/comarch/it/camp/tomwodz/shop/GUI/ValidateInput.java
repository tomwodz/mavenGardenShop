package pl.comarch.it.camp.tomwodz.shop.GUI;

import org.springframework.stereotype.Component;

@Component
public class ValidateInput implements IValidateInput{
    public boolean validateName(String name){
        return name.matches("[A-Z][a-zA-Z]*");
    }

    public boolean validateChoise(String choise){return choise.matches("[1-5]");}
    public boolean validateQuantity(String quantity){return quantity.matches("[0-9]*");}
    public boolean validateCode(String code){return code.matches("[0-9]*");}
}
