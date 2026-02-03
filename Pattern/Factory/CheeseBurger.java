public class CheeseBurger implements Burger {

    @Override
    public String getNom()     { return "CheeseBurger"; }

    @Override
    public String getRecette() { return "Pain sésame, steak haché, cheddar fondu"; }

    @Override
    public double getPrix()    { return 10.00; }

    @Override
    public void afficher() {
        System.out.println("--- " + getNom() + " ---");
        System.out.println("Recette : " + getRecette());
        System.out.printf("Prix    : %.2f€%n", getPrix());
    }
}
