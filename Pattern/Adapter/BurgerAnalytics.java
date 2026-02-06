import java.util.List;

public class BurgerAnalytics {

    private final AnalyseurVentes analyseur;

    public BurgerAnalytics(AnalyseurVentes analyseur) {
        this.analyseur = analyseur;
    }

    public void genererRapport() {
        List<String[]> ventes = analyseur.getVentes();

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║       RAPPORT VENTES — BurgerFast       ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.printf("║ %-18s %8s %10s      ║%n", "Produit", "Qte", "CA (€)");
        System.out.println("╠══════════════════════════════════════════╣");

        for (String[] vente : ventes) {
            System.out.printf("║ %-18s %8s %10s      ║%n", vente[0], vente[1], vente[2]);
        }

        System.out.println("╠══════════════════════════════════════════╣");
        System.out.printf("║ %-18s %8s %10.2f      ║%n", "TOTAL", "", analyseur.getCiffreAffairesTotal());
        System.out.println("╚══════════════════════════════════════════╝");
    }
}