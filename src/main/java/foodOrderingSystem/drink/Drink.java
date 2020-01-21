package foodOrderingSystem.drink;

import foodOrderingSystem.meal.MenuItem;

import java.math.BigDecimal;

public class Drink implements MenuItem {

    private BigDecimal price;
    private String description;

    public Drink(String description, BigDecimal price){
        this.description = description;
        this.price = price;
    }

    @Override
    public BigDecimal getPrice() {
        return price ;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Drinks:  " + description  +
                ", " + price + " euro";
    }
}

