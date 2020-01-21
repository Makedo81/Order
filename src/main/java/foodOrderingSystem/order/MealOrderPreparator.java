package foodOrderingSystem.order;

import foodOrderingSystem.meal.MenuItem;
import foodOrderingSystem.menu.MenuPicker;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MealOrderPreparator {

    private final MenuPicker menuPicker = new MenuPicker();

    public List<MenuItem> createList(List<Integer> integerList, List<String> cuisine) {
        List<MenuItem> list = new ArrayList<>();
        for (int i = 0; i < integerList.size(); i++) {
            list.add(Objects.requireNonNull(menuPicker.selectMenu(cuisine.get(i))).getMenu().get(integerList.get(i)));
        }
        return list;
    }
}
