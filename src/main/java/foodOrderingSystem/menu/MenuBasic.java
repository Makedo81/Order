package foodOrderingSystem.menu;

import foodOrderingSystem.meal.MenuItem;
import java.util.Map;

public interface MenuBasic {

    void showMeal();
    Map<Integer, MenuItem> getMenu();
}
