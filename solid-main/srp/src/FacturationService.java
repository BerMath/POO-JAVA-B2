public class FacturationService {
    private CalculateurTVA calculateur;
    private AfficheurDocument afficheur;
    private SauvegardeDocument sauvegarde;

    public FacturationService() {
        this.calculateur = new CalculateurTVA();
        this.afficheur = new AfficheurDocument();
        this.sauvegarde = new SauvegardeDocument();
    }

    public void creerFacture(double montantHT, String clientName) {
        Document facture = new Document("FACTURE", montantHT, clientName);
        traiterDocument(facture);
    }

    public void creerDevis(double montantHT) {
        Document devis = new Document("DEVIS", montantHT);
        traiterDocument(devis);
    }

    private void traiterDocument(Document document) {
        calculateur.calculer(document);
        afficheur.afficher(document);
        sauvegarde.sauvegarder(document);
    }
}