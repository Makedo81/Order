package foodOrderingSystem.order;

import foodOrderingSystem.drink.ExtraIce;
import foodOrderingSystem.drink.ExtraLemon;
import foodOrderingSystem.meal.MenuItem;
import foodOrderingSystem.menu.MenuPicker;

public class DrinkOrderPreparator {

    private final MenuPicker menuPicker = new MenuPicker();

    public DrinkOrderPreparator(){
    }

    public MenuItem createExtraDrink(MenuItem drink, boolean withLemon, boolean withIce) {

        if (!withIce && withLemon) {
            System.out.println("adding lemon");
            drink = new ExtraLemon(drink);
        }
        if (!withLemon && withIce) {
            System.out.println("adding ice");
            drink = new ExtraIce(drink);
        }
        if (withIce && withLemon) {
            System.out.println("adding ice and lemon");
            drink = new ExtraIce(drink);
            drink = new ExtraLemon(drink);
        }
        return drink;
    }

    public MenuItem createDrink(Integer number, String cuisine, boolean withLemon, boolean withIce){
        MenuItem drink = menuPicker.selectMenu(cuisine).getMenu().get(number);
        return createExtraDrink( drink,  withLemon, withIce);
    }
}