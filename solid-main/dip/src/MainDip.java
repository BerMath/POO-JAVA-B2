import java.util.Scanner;

public class MainDip {

    private static final int CHOIX_EMAIL = 1;
    private static final int CHOIX_SMS = 2;
    private static final int CHOIX_PUSH = 3;
    private static final int CHOIX_QUITTER = 0;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Initialisation avec Email par défaut
            NotificationService service = new NotificationService(new EmailSender());
            executerBoucleMenu(scanner, service);
        }
    }

    private static void executerBoucleMenu(Scanner scanner, NotificationService service) {
        boolean quitter = false;

        while (!quitter) {
            afficherMenu();

            int choix = lireEntier(scanner, "Choix : ");

            switch (choix) {
                case CHOIX_EMAIL:
                    envoyerNotification(scanner, service, new EmailSender());
                    break;
                case CHOIX_SMS:
                    envoyerNotification(scanner, service, new SmsSender());
                    break;
                case CHOIX_PUSH:
                    envoyerNotification(scanner, service, new PushNotificationSender());
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
        System.out.println(CHOIX_EMAIL + ". Envoyer un email");
        System.out.println(CHOIX_SMS + ". Envoyer un SMS");
        System.out.println(CHOIX_PUSH + ". Envoyer une notification push");
        System.out.println(CHOIX_QUITTER + ". Quitter");
    }

    private static void envoyerNotification(Scanner scanner, NotificationService service, MessageSender sender) {
        String message = lireMessage(scanner);
        service.setMessageSender(sender);
        service.envoyer(message);
    }

    private static String lireMessage(Scanner scanner) {
        System.out.print("Message : ");
        String message = scanner.nextLine().trim();
        while (message.isEmpty()) {
            System.out.println("Le message ne peut pas être vide.");
            System.out.print("Message : ");
            message = scanner.nextLine().trim();
        }
        return message;
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