package foodOrderingSystem.drink;

import foodOrderingSystem.meal.MenuItem;

import java.math.BigDecimal;

public class ExtraIce extends DrinkDecorator {

    public ExtraIce(MenuItem drink) {
        super(drink);
    }

    @Override
    public BigDecimal getPrice(){
        return super.getPrice();
    }

    @Override
    public String getDescription(){
        return super.getDescription()+ " with ice";
    }

    @Override
    public String toString() {
        return getDescription() +  ", price =" + getPrice();
    }

}
