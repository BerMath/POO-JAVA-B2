public class Main {
    public static void main(String[] args) {

        
        Burger veggie  = BurgerFactory.créer(BurgerType.VEGGIE);
        Burger cheese  = BurgerFactory.créer(BurgerType.CHEESEBURGER);
        Burger chicken = BurgerFactory.créer(BurgerType.CHICKEN);

        veggie.afficher();
        System.out.println();
        cheese.afficher();
        System.out.println();
        chicken.afficher();
    }
}
