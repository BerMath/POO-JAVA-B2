public abstract class Remise {
    private final double tauxRemise;
    
    public Remise(double tauxRemise) {
        if (tauxRemise < 0 || tauxRemise > 1) {
            throw new IllegalArgumentException("Le taux doit être entre 0 et 1");
        }
        this.tauxRemise = tauxRemise;
    }

    public double calculMontantTotal(double montant) {
        return montant * (1 - tauxRemise); // Correction : on applique la réduction
    }

    public double getTauxRemise() {
        return tauxRemise;
    }

    public double getPourcentageRemise() {
        return tauxRemise * 100;
    }

    public abstract String getTypeClient();
}