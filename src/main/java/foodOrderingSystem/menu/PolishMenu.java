package foodOrderingSystem.menu;

import foodOrderingSystem.meal.Meal;
import foodOrderingSystem.meal.MenuItem;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PolishMenu implements MenuBasic {

    public String name;
    private Map<Integer, MenuItem> polish ;

    public PolishMenu (String name){
        this.name = name;
        this.polish = getMenu();
    }

    public Map<Integer, MenuItem> getMenu() {
        Map<Integer, MenuItem> polish = new HashMap<>();
        polish.put(1,new Meal("Potatos with roasted ham", new BigDecimal("15.30")));
        polish.put(2,new Meal("Mushroom soup", new BigDecimal("12.30")));
        polish.put(3,new Meal("Beef stew", new BigDecimal("16.50")));
        polish.put(4,new Meal("Bigos", new BigDecimal("13.00")));
        return polish;
    }

    @Override
    public void showMeal() {
        for (Map.Entry<Integer, MenuItem> entry : polish.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue().getDescription()+", " + entry.getValue().getPrice() +" euro");
        }
    }
}
