package foodOrderingSystem.drink;

import foodOrderingSystem.meal.MenuItem;

import java.math.BigDecimal;

public abstract class DrinkDecorator implements MenuItem {

    private final MenuItem drink;

    protected DrinkDecorator(MenuItem drink){
        this.drink = drink;
    }

    @Override
    public BigDecimal getPrice(){
        return drink.getPrice();
    }

    @Override
    public String getDescription(){
        return drink.getDescription();
    }

    @Override
    public String toString() {
        return
                "drink :" + drink.getDescription() + drink.getPrice();
    }
}
