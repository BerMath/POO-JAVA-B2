public class CalculateurRemise {

    public double calculerTotal(Remise remise, double montant) {
        if (montant < 0) {
            throw new IllegalArgumentException("Le montant ne peut pas être négatif");
        }
        return remise.calculMontantTotal(montant);
    }
}