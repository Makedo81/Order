package foodOrderingSystem.menu;

import foodOrderingSystem.meal.Meal;
import foodOrderingSystem.meal.MenuItem;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ItalianMenu implements MenuBasic {

    public String name;
    private Map<Integer, MenuItem> italian;

    public ItalianMenu (String name){
        this.name = name;
        this.italian = getMenu();
    }

    public Map<Integer, MenuItem> getMenu() {
        Map<Integer, MenuItem> italian = new HashMap<>();
        italian.put(1, new Meal("Pizza", new BigDecimal(15)));
        italian.put(2, new Meal("Ravioli", new BigDecimal(10)));
        italian.put(3, new Meal("Pasta", new BigDecimal(15)));
        italian.put(4, new Meal("Risotto", new BigDecimal(15)));
        return italian;
    }

    @Override
    public void showMeal() {
        for (Map.Entry<Integer, MenuItem> entry : italian.entrySet()) {
            System.out.println(entry.getKey()+
                    " : " +
                    entry.getValue().getDescription()+
                    "," +
                    entry.getValue().getPrice() +"euro");
        }
    }
}
