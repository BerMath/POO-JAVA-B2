public class ChickenBurger implements Burger {

    @Override
    public String getNom()     { return "Chicken Burger"; }

    @Override
    public String getRecette() { return "Pain burger, poulet pané croustillant, sauce BBQ"; }

    @Override
    public double getPrix()    { return 9.00; }

    @Override
    public void afficher() {
        System.out.println("--- " + getNom() + " ---");
        System.out.println("Recette : " + getRecette());
        System.out.printf("Prix    : %.2f€%n", getPrix());
    }
}
