package foodOrderingSystem.menu;

import foodOrderingSystem.drink.Drink;
import foodOrderingSystem.meal.MenuItem;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class DrinkMenu implements MenuBasic {

    public String name;
    private Map<Integer, MenuItem> drinks ;

    public DrinkMenu(String name) {
        this.name = name;
        this.drinks = getMenu();
    }

    public Map<Integer, MenuItem> getMenu() {
        Map<Integer, MenuItem> drinks = new HashMap<>();
        drinks.put(1,new Drink("Coke", new BigDecimal("2.00")));
        drinks.put(2,new Drink("Tea", new BigDecimal("4.00")));
        drinks.put(3,new Drink("Matcha", new BigDecimal("3.50")));
        drinks.put(4,new Drink("Coffee", new BigDecimal("4.50")));
        drinks.put(5,new Drink("Espresso", new BigDecimal("4.00")));
        drinks.put(6,new Drink("Cafe Latte", new BigDecimal("4.70")));
        return drinks;
    }

    public String getName() {
        return name;
    }

    @Override
    public void showMeal() {
        for (Map.Entry<Integer, MenuItem> entry : drinks.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue().getDescription()+"," + entry.getValue().getPrice() +"euro");
        }
    }
}
