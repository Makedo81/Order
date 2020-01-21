package foodOrderingSystem.order;

import foodOrderingSystem.meal.MenuItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FinalOrderPreparator {

    private final List<MenuItem> mealOrdersList;
    private final List<MenuItem> drinkOrdersList;
    private final List<MenuItem> dessertOrdersList;
    private BigDecimal totalPrice;

    public static class OrderBuilder {
        List<MenuItem> mealOrdersList = new ArrayList<>();
        List<MenuItem> drinkOrdersList = new ArrayList<>();
        List<MenuItem> dessertOrdersList = new ArrayList<>();

        public FinalOrderPreparator.OrderBuilder mealOrder(final List<MenuItem> mealOrdersList) {
            this.mealOrdersList = mealOrdersList;
            return this;
        }

        public FinalOrderPreparator.OrderBuilder drinkOrder(final List<MenuItem> drinkOrdersList) {
            this.drinkOrdersList = drinkOrdersList;
            return this;
        }

        public FinalOrderPreparator.OrderBuilder dessertOrder(final List<MenuItem> dessertOrdersList) {
            this.dessertOrdersList = dessertOrdersList;
            return this;
        }

        public FinalOrderPreparator build() {
            return new FinalOrderPreparator(mealOrdersList, drinkOrdersList,dessertOrdersList);
        }
    }

    private FinalOrderPreparator(List<MenuItem> mealOrdersList, List<MenuItem> drinkOrdersList, List<MenuItem> dessertOrdersList ){
        this.mealOrdersList = mealOrdersList;
        this.drinkOrdersList = drinkOrdersList;
        this.dessertOrdersList = dessertOrdersList;
        this.totalPrice = calculatePrice(this);
    }

    public BigDecimal calculatePrice(FinalOrderPreparator order){
        BigDecimal priceMeals = order.getMealOrdersList().stream().map(MenuItem::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal priceDessert = order.getDessertOrdersList().stream().map(MenuItem::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal priceDrink = order.getDrinkOrdersList().stream().map(MenuItem::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal total = priceMeals.add(priceDessert).add(priceDrink);
        return total;
    }

    public List<MenuItem> getMealOrdersList() {
        return mealOrdersList;
    }

    public List<MenuItem> getDrinkOrdersList() {
        return drinkOrdersList;
    }

    public List<MenuItem> getDessertOrdersList() {
        return dessertOrdersList;
    }

    @Override
    public String toString() {
        return "ORDER: " +"\n"+
                "LUNCH " + mealOrdersList + "\n" +
                "DRINKS " + drinkOrdersList + "\n" +
                "DESSERTS " + dessertOrdersList + "\n" +
                "Total price : " + totalPrice + " euro";
    }
}
