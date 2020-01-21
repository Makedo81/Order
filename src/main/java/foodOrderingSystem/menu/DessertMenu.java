package foodOrderingSystem.menu;

import foodOrderingSystem.meal.Meal;
import foodOrderingSystem.meal.MenuItem;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class DessertMenu implements MenuBasic {

    public String name;
    private final Map<Integer, MenuItem> desserts ;

    public DessertMenu(String name) {
        this.name = name;
        this.desserts = getMenu();
    }

    public Map<Integer, MenuItem> getMenu() {
        Map<Integer, MenuItem> desserts = new HashMap<>();
        desserts.put(1,new Meal("Ice-Cream", new BigDecimal("8.00")));
        desserts.put(2,new Meal("Fruit sorbet", new BigDecimal("8.00")));
        desserts.put(3,new Meal("Tiramisu", new BigDecimal("7.50")));
        desserts.put(4,new Meal("Creme brulee", new BigDecimal("6.00")));
        desserts.put(5,new Meal("Cheesecake", new BigDecimal("7.50")));
        return desserts;
    }

    @Override
    public void showMeal() {
        for (Map.Entry<Integer, MenuItem> entry : desserts.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue().getDescription()+" ," +entry.getValue().getPrice() +" euro");
        }
    }
}