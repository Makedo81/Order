package foodOrderingSystem.menu;

public final class MenuPicker{

    public static final String ITALIAN = "ITALIAN";
    public static final String POLISH = "POLISH";
    public static final String DRINK = "DRINK";
    public static final String DESSERT = "DESSERT";

    public final MenuBasic selectMenu(final String menu) {
        switch (menu) {
            case ITALIAN:
                return new ItalianMenu(ITALIAN);
            case POLISH:
                return new PolishMenu(POLISH);
            case DRINK:
                return new DrinkMenu(DRINK);
            case DESSERT:
                return new DessertMenu(DESSERT);
            default:
                return null;
        }
    }
}
