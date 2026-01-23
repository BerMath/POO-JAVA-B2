public abstract class CompteBancaireBase {
    protected double solde = 100;

    public double getSolde() {
        return solde;
    }

    public abstract void afficherSolde();
    
    public abstract boolean peutRetirer();
}