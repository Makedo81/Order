package foodOrderingSystem.meal;

import java.math.BigDecimal;

public class Meal implements MenuItem {

    private final String description;
    private final BigDecimal price;

    public Meal(String description, BigDecimal price){
        this.description = description;
        this.price = price;
    }

    @Override
    public BigDecimal getPrice(){
        return price;
    }

    @Override
    public String getDescription(){
        return description;
    }

    @Override
    public String toString() {
        return "Meals: " + description + ", price= " + price + "euro" + ";";
    }
}
