import java.time.LocalDate;

public class PEL extends CompteBancaireBase {
    private final double tauxInteret = 0.03;
    private final LocalDate dateEcheance;

    public PEL() {
        this.dateEcheance = LocalDate.now().plusYears(4);
    }

    @Override
    public void afficherSolde() {
        System.out.println("Solde PEL : " + solde);
        System.out.println("Taux d'intérêt : " + (tauxInteret * 100) + "%");
        System.out.println("Date d'échéance : " + dateEcheance);
    }

    @Override
    public boolean peutRetirer() {
        return LocalDate.now().isAfter(dateEcheance) || 
               LocalDate.now().isEqual(dateEcheance);
    }

    public void retirerSiAutorise(double montant) {
        if (!peutRetirer()) {
            System.out.println("Retrait impossible avant l'échéance.");
            return;
        }
        if (montant > solde) {
            System.out.println("Solde insuffisant.");
            return;
        }
        solde -= montant;
        System.out.println("Retrait effectué. Nouveau solde : " + solde);
    }
}