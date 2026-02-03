public class TPE {

    private static TPE instance;
    private double chiffreAffaires;

   
    private TPE() {
        this.chiffreAffaires = 0;
    }


    public static TPE getInstance() {
        if (instance == null) {
            instance = new TPE();
        }
        return instance;
    }

    public void addTransaction(String caissier, double montant) {
        chiffreAffaires += montant;
        System.out.printf("[%s] Transaction de %.2f€ — CA total : %.2f€%n", caissier, montant, chiffreAffaires);
    }

    public double getChiffreAffaires() {
        return chiffreAffaires;
    }


    public void reset() {
        chiffreAffaires = 0;
        System.out.println("[TPE] Journée réinitialisée — CA remis à 0€\n");
    }
}