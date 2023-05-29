package pl.comarch.it.camp.tomwodz.shop.GUI;

import org.springframework.stereotype.Component;

@Component
public class ValidateInput implements IValidateInput{

    @Override
    public boolean validateName(String name){return name.matches("[A-Z][a-zA-Z]*");}
    @Override
    public boolean validateQuantity(String quantity){return quantity.matches("[0-9]*");}
    @Override
    public boolean validateCode(String code){return code.matches("[0-9]*");}
}
