public class BurgerFactory {

    public static Burger créer(BurgerType type) {
        return switch (type) {
            case VEGGIE      -> new BurgerVeggie();
            case CHEESEBURGER -> new CheeseBurger();
            case CHICKEN     -> new ChickenBurger();
        };
    }
}
