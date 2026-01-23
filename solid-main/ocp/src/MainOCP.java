import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class MainOCP {

    private static final int CHOIX_STANDARD = 1;
    private static final int CHOIX_ETUDIANT = 2;
    private static final int CHOIX_VIP = 3;
    private static final int CHOIX_SENIOR = 4;
    private static final int CHOIX_EMPLOYE = 5;
    private static final int CHOIX_QUITTER = 0;

    // Map pour associer les choix aux types de remise
    private static final Map<Integer, Remise> REMISES = new HashMap<>();

    static {
        REMISES.put(CHOIX_STANDARD, new RemiseStandard());
        REMISES.put(CHOIX_ETUDIANT, new RemiseEtudiant());
        REMISES.put(CHOIX_VIP, new RemiseVip());
        REMISES.put(CHOIX_SENIOR, new RemiseSenior());
        REMISES.put(CHOIX_EMPLOYE, new RemiseEmploye());
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            CalculateurRemise calculateur = new CalculateurRemise();
            executerBoucleMenu(scanner, calculateur);
        }
    }

    private static void executerBoucleMenu(Scanner scanner, CalculateurRemise calculateur) {
        boolean quitter = false;

        while (!quitter) {
            afficherMenu();

            int choix = lireEntier(scanner, "Choix : ");

            if (choix == CHOIX_QUITTER) {
                quitter = true;
                System.out.println("Au revoir !");
                continue;
            }

            Remise remise = REMISES.get(choix);

            if (remise == null) {
                System.out.println("Choix invalide. Veuillez réessayer.");
                continue;
            }

            double montant = lireDoublePositif(scanner, "Montant HT : ");

            try {
                double total = calculateur.calculerTotal(remise, montant);
                afficherResultat(remise, montant, total);
            } catch (IllegalArgumentException e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }

    private static void afficherMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println(CHOIX_STANDARD + ". Client standard (0% de remise)");
        System.out.println(CHOIX_ETUDIANT + ". Client étudiant (10% de remise)");
        System.out.println(CHOIX_VIP + ". Client VIP (20% de remise)");
        System.out.println(CHOIX_SENIOR + ". Client senior (15% de remise)");
        System.out.println(CHOIX_EMPLOYE + ". Employé (25% de remise)");
        System.out.println(CHOIX_QUITTER + ". Quitter");
    }

    private static void afficherResultat(Remise remise, double montantHT, double montantFinal) {
        System.out.println("\n--- RÉSULTAT ---");
        System.out.println("Type de client : " + remise.getTypeClient());
        System.out.println("Montant HT : " + String.format("%.2f", montantHT) + " €");
        
        if (remise.getTauxRemise() > 0) {
            double montantRemise = montantHT * remise.getTauxRemise();
            System.out.println("Remise (" + String.format("%.0f", remise.getPourcentageRemise()) + "%) : -" 
                + String.format("%.2f", montantRemise) + " €");
        }
        
        System.out.println("Montant final : " + String.format("%.2f", montantFinal) + " €");
    }

    private static int lireEntier(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre entier valide.");
            }
        }
    }

    private static double lireDoublePositif(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double valeur = Double.parseDouble(scanner.nextLine().trim());
                if (valeur < 0) {
                    System.out.println("Le montant doit être positif.");
                } else {
                    return valeur;
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide (ex: 123.45).");
            }
        }
    }
}