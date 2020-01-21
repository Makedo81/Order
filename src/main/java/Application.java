
import foodOrderingSystem.meal.MenuItem;
import foodOrderingSystem.menu.DessertMenu;
import foodOrderingSystem.menu.DrinkMenu;
import foodOrderingSystem.menu.MenuPicker;
import foodOrderingSystem.order.DrinkOrderPreparator;
import foodOrderingSystem.order.MealOrderPreparator;
import foodOrderingSystem.order.FinalOrderPreparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static foodOrderingSystem.menu.MenuPicker.*;

public class Application {

    public static void main(String[] args) {

        MealOrderPreparator mealOrderPreparator = new MealOrderPreparator();
        MenuPicker menuPicker = new MenuPicker();
        DrinkMenu menu = new DrinkMenu(DRINK);
        DessertMenu dessertMenu = new DessertMenu(DESSERT);
        DrinkOrderPreparator drinkOrderPreparator = new DrinkOrderPreparator();
        List<MenuItem> menuItemsList;
        List<MenuItem> drinksList = new ArrayList<>();
        List<MenuItem> dessertList;
        List<Integer> numbers = new ArrayList<>();
        List<String> cuisineList = new ArrayList<>();
        List<Integer> numbersDessert = new ArrayList<>();
        List<String> dessert = new ArrayList<>();
        String drink = "YES";
        String addition = "EXTRA";
        boolean lemon = false;
        boolean ice = false;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Choose menu : ITALIAN, POLISH, DRINK ");
            String cuisine = sc.next();
            switch (cuisine) {
                case ITALIAN:
                case POLISH: {
                    Objects.requireNonNull(menuPicker.selectMenu(cuisine)).showMeal();
                    System.out.println("Select meals from menu by selecting number");
                    numbers.add(sc.nextInt());
                    cuisineList.add(cuisine);
                }
                case DESSERT: {
                    dessertMenu.showMeal();
                    System.out.println("add dessert by selecting number");
                    Integer number = sc.nextInt();
                    numbersDessert.add(number);
                    dessert.add(DESSERT);
                }
                System.out.println("Type YES to add drink or any key to exit");
                case DRINK: {
                    if (cuisine.equals(DRINK) || sc.next().equals(drink)) {
                        menu.showMeal();
                        System.out.println("add drink by selecting number");
                        Integer menuPosition = sc.nextInt();
                        System.out.println("Type EXTRA to add lemon or ice or any key to exit");
                        System.out.println("To finish order type any key");
                        if (sc.next().equals(addition)) {
                            System.out.println("type TRUE to add lemon or FALSE then any key to skip");
                            lemon = sc.nextBoolean();
                            System.out.println("type TRUE to add ice or FALSE to skip");
                            ice = sc.nextBoolean();
                            drinksList.add(drinkOrderPreparator.createDrink(menuPosition, DRINK, lemon, ice));
                        } else
                            drinksList.add(drinkOrderPreparator.createDrink(menuPosition, DRINK, lemon, ice));
                    }break;
                }
            }

            menuItemsList = mealOrderPreparator.createList(numbers, cuisineList);
            dessertList = mealOrderPreparator.createList(numbersDessert, dessert);

            FinalOrderPreparator finalOrderPreparator = new FinalOrderPreparator.OrderBuilder()
                    .mealOrder(menuItemsList)
                    .dessertOrder(dessertList)
                    .drinkOrder(drinksList)
                    .build();

            System.out.println(finalOrderPreparator);
            System.out.println("Type N to continue ordering or E exit");
        } while (!sc.next().equals("E"));
    }
}

