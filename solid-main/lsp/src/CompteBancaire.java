public class CompteCourant extends CompteBancaireBase {

    @Override
    public void afficherSolde() {
        System.out.println("Solde compte courant : " + solde);
    }

    @Override
    public boolean peutRetirer() {
        return true;
    }

    public void retirer(double montant) {
        if (montant <= 0) {
            System.out.println("Le montant doit être positif.");
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