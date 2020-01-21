package foodOrderingSystem.drink;

import foodOrderingSystem.meal.MenuItem;

import java.math.BigDecimal;

public class ExtraLemon extends DrinkDecorator {

    public ExtraLemon(MenuItem drink) {
        super(drink);
    }

    @Override
    public BigDecimal getPrice(){
        return super.getPrice();
    }

    @Override
    public String getDescription(){
        return super.getDescription() + " with lemon";
    }

    @Override
    public String toString() {
        return getDescription() +  ", price = " + getPrice() + "euro";
    }
}
