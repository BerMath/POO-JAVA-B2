public class Main {
    public static void main(String[] args) {


        TPE tpeCaissier1 = TPE.getInstance();
        TPE tpeCaissier2 = TPE.getInstance();
        TPE tpeCaissier3 = TPE.getInstance();

  
        System.out.println("Même instance ? " + (tpeCaissier1 == tpeCaissier2 && tpeCaissier2 == tpeCaissier3));
        System.out.println();


        System.out.println("===== JOURNÉE 1 =====");
        tpeCaissier1.addTransaction("Alice", 10.00);   // CheeseBurger
        tpeCaissier2.addTransaction("Bob",   8.00);    // Burger Veggie
        tpeCaissier1.addTransaction("Alice", 9.00);    // Chicken Burger
        tpeCaissier3.addTransaction("Clara", 18.00);   // 2x Chicken Burger
        tpeCaissier2.addTransaction("Bob",   10.00);   // CheeseBurger

        System.out.printf("%nFin de journée — CA total : %.2f€%n%n", TPE.getInstance().getChiffreAffaires());

 
        TPE.getInstance().reset();


        System.out.println("===== JOURNÉE 2 =====");
        tpeCaissier3.addTransaction("Clara", 8.00);    // Burger Veggie
        tpeCaissier1.addTransaction("Alice", 9.00);    // Chicken Burger

        System.out.printf("%nFin de journée — CA total : %.2f€%n", TPE.getInstance().getChiffreAffaires());
    }
}