public class Main {
    public static void main(String[] args) {

        
        LecteurCSV lecteur = new LecteurCSV("ventes.csv");

        
        CSVAdapter adapter = new CSVAdapter(lecteur);

        /
        BurgerAnalytics analytics = new BurgerAnalytics(adapter);

       
        analytics.genererRapport();
    }
}
