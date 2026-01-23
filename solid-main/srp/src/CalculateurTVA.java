public class CalculateurTVA {
    private static final double TAUX_TVA = 0.2;

    public void calculer(Document document) {
        double tva = document.getMontantHT() * TAUX_TVA;
        double total = document.getMontantHT() + tva;
        
        document.setTva(tva);
        document.setTotalTTC(total);
    }
}