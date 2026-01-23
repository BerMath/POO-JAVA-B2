import java.util.Scanner;

public class MainIsp {

    private static final int FONCTION_IMPRIMER = 1;
    private static final int FONCTION_SCANNER = 2;
    private static final int FONCTION_FAXER = 3;
    private static final int FONCTION_QUITTER = 0;

    private static final int MACHINE_SIMPLE = 1;
    private static final int MACHINE_MULTIFONCTION = 2;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            executerBoucleMenu(scanner);
        }
    }

    private static void executerBoucleMenu(Scanner scanner) {
        boolean quitter = false;

        while (!quitter) {
            afficherMenuFonction();

            int fonction = lireEntier(scanner, "Choix fonctionnalité : ");

            if (fonction == FONCTION_QUITTER) {
                quitter = true;
                System.out.println("Au revoir !");
                continue;
            }

            MachineWrapper machine = choisirMachine(scanner);

            try {
                executerFonction(machine, fonction);
            } catch (UnsupportedOperationException e) {
                System.out.println("Fonctionnalité non supportée par cette machine");
            }
        }
    }

    private static void afficherMenuFonction() {
        System.out.println("\n--- MENU ---");
        System.out.println(FONCTION_IMPRIMER + ". Imprimer");
        System.out.println(FONCTION_SCANNER + ". Scanner");
        System.out.println(FONCTION_FAXER + ". Faxer");
        System.out.println(FONCTION_QUITTER + ". Quitter");
    }

    private static void afficherMenuMachine() {
        System.out.println("\nChoisir la machine :");
        System.out.println(MACHINE_SIMPLE + ". Imprimante simple");
        System.out.println(MACHINE_MULTIFONCTION + ". Imprimante multifonction");
    }

    private static MachineWrapper choisirMachine(Scanner scanner) {
        afficherMenuMachine();

        int choixMachine = lireEntier(scanner, "Choix machine : ");

        Object machine;
        if (choixMachine == MACHINE_MULTIFONCTION) {
            machine = new ImprimanteMultifonction();
        } else {
            machine = new ImprimanteSimple();
        }

        return new MachineWrapper(machine);
    }

    private static void executerFonction(MachineWrapper machine, int fonction) {
        switch (fonction) {
            case FONCTION_IMPRIMER:
                machine.print();
                break;
            case FONCTION_SCANNER:
                machine.scan();
                break;
            case FONCTION_FAXER:
                machine.fax();
                break;
            default:
                System.out.println("Fonction inconnue");
        }
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
}