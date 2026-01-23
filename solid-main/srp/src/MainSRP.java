import java.util.Scanner;

public class MainSRP {

    private static final int CHOIX_FACTURE = 1;
    private static final int CHOIX_DEVIS = 2;
    private static final int CHOIX_QUITTER = 0;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            FacturationService service = new FacturationService();
            executerBoucleMenu(scanner, service);
        }
    }

    private static void executerBoucleMenu(Scanner scanner, FacturationService service) {
        boolean quitter = false;

        while (!quitter) {
            afficherMenu();

            int choix = lireEntier(scanner, "Choix : ");

            switch (choix) {
                case CHOIX_FACTURE:
                    traiterFacture(scanner, service);
                    break;
                case CHOIX_DEVIS:
                    traiterDevis(scanner, service);
                    break;
                case CHOIX_QUITTER:
                    quitter = true;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private static void afficherMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println(CHOIX_FACTURE + ". Créer une facture");
        System.out.println(CHOIX_DEVIS + ". Créer un devis");
        System.out.println(CHOIX_QUITTER + ". Quitter");
    }

    private static void traiterFacture(Scanner scanner, FacturationService service) {
        double montantHT = lireDoublePositif(scanner, "Montant HT : ");
        String client = lireNomClient(scanner);
        service.creerFacture(montantHT, client);
    }

    private static void traiterDevis(Scanner scanner, FacturationService service) {
        double montantHT = lireDoublePositif(scanner, "Montant HT : ");
        service.creerDevis(montantHT);
    }

    private static String lireNomClient(Scanner scanner) {
        String client;
        do {
            System.out.print("Nom du client : ");
            client = scanner.nextLine().trim();
            if (client.isEmpty()) {
                System.out.println("Le nom du client ne peut pas être vide.");
            }
        } while (client.isEmpty());
        return client;
    }

    private static int lireEntier(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            try {
                int valeur = Integer.parseInt(scanner.nextLine().trim());
                return valeur;
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre entier valide.");
            }
        }
    }

    private static double lireDoublePositif(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
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