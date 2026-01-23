public class AfficheurDocument {

    public void afficher(Document document) {
        System.out.println("\n--- " + document.getType() + " ---");
        System.out.println("Date : " + document.getDate());
        
        if (document.getClientName() != null) {
            System.out.println("Client : " + document.getClientName());
        }
        
        System.out.println("Montant HT : " + document.getMontantHT());
        System.out.println("TVA : " + document.getTva());
        System.out.println("Total TTC : " + document.getTotalTTC());
        
        if (document.getType().equals("DEVIS")) {
            System.out.println("Valable 30 jours");
        }
    }
}