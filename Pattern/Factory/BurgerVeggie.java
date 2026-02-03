public class BurgerVeggie implements Burger {

    @Override
    public String getNom()     { return "Burger Veggie"; }

    @Override
    public String getRecette() { return "Pain complet, salade, tomate, carotte"; }

    @Override
    public double getPrix()    { return 8.00; }

    @Override
    public void afficher() {
        System.out.println("--- " + getNom() + " ---");
        System.out.println("Recette : " + getRecette());
        System.out.printf("Prix    : %.2f€%n", getPrix());
    }
}
