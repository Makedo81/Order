import foodOrderingSystem.drink.Drink;
import foodOrderingSystem.drink.ExtraIce;
import foodOrderingSystem.drink.ExtraLemon;
import foodOrderingSystem.meal.MenuItem;
import foodOrderingSystem.order.FinalOrderPreparator;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FoodOrderingTestSuites {

    @Test
    public void testAddingExtraLemon() {
        //Given
        MenuItem coke = new Drink("coke" , new BigDecimal("1.00"));
        MenuItem tea = new Drink("tea" , new BigDecimal("2.00"));

        //When
        coke = new ExtraLemon(coke);
        coke = new ExtraIce(coke);
        System.out.println(coke.getPrice());
        tea = new ExtraLemon(tea);
        System.out.println(tea);

        //Then
        Assert.assertEquals("coke with lemon with ice", coke.getDescription());
        Assert.assertEquals(new BigDecimal("1.00"), coke.getPrice());
        Assert.assertEquals("tea with lemon", tea.getDescription());
    }

    @Test
    public void testCreatingOrder() {
        //Given
        MenuItem coke = new Drink("coke" , new BigDecimal("1.00"));
        MenuItem tea = new Drink("tea" , new BigDecimal("2.00"));
        MenuItem meal = new Drink("meal" , new BigDecimal("1.00"));
        List<MenuItem> drinksList = new ArrayList<>();
        List<MenuItem> mealsList = new ArrayList<>();
        mealsList.add(meal);
        drinksList.add(coke);
        drinksList.add(tea);

        FinalOrderPreparator order = new FinalOrderPreparator.OrderBuilder()
                .drinkOrder(drinksList)
                .mealOrder(mealsList)
                .build();
        //When
        int drinksNumber = order.getDrinkOrdersList().size();
        int mealsNumber = order.getMealOrdersList().size();

        //Then
        Assert.assertEquals(2, drinksNumber);
        Assert.assertEquals(1, mealsNumber);
    }

    @Test
    public void testCalculatePrice() {
        //Given
        MenuItem coke = new Drink("coke" , new BigDecimal("1.00"));
        MenuItem tea = new Drink("tea" , new BigDecimal("2.00"));
        MenuItem meal = new Drink("meal" , new BigDecimal("1.00"));
        List<MenuItem> drinksList = new ArrayList<>();
        List<MenuItem> mealsList = new ArrayList<>();
        mealsList.add(meal);
        drinksList.add(coke);
        drinksList.add(tea);

        FinalOrderPreparator order = new FinalOrderPreparator.OrderBuilder()
                .drinkOrder(drinksList)
                .mealOrder(mealsList)
                .build();

        FinalOrderPreparator order1 = new FinalOrderPreparator.OrderBuilder()
                .mealOrder(mealsList)
                .build();
        //When
        BigDecimal price = order.calculatePrice(order);
        BigDecimal price1 = order.calculatePrice(order1);

        //Then
        Assert.assertEquals(new BigDecimal("4.00"), price);
        Assert.assertEquals(new BigDecimal("1.00"), price1);
    }
}


