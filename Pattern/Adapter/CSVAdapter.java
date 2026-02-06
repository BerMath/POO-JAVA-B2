import java.util.*;

public class CSVAdapter implements AnalyseurVentes {

    private final LecteurCSV lecteurCSV;
    private List<String[]> ventesAdaptees;
    private double caTotal;

    public CSVAdapter(LecteurCSV lecteurCSV) {
        this.lecteurCSV = lecteurCSV;
        this.adaptor();
    }

    
    private void adaptor() {
        
        Map<String, double[]> aggregation = new LinkedHashMap<>();

        for (String[] ligne : lecteurCSV.lire()) {
            
            String produit      = ligne[1];
            double qte          = Double.parseDouble(ligne[2]);
            double prixUnitaire = Double.parseDouble(ligne[3]);

            aggregation.computeIfAbsent(produit, k -> new double[]{0, 0});
            aggregation.get(produit)[0] += qte;                  
            aggregation.get(produit)[1] += qte * prixUnitaire;  
        }

        
        ventesAdaptees = new ArrayList<>();
        caTotal = 0;

        for (Map.Entry<String, double[]> entry : aggregation.entrySet()) {
            ventesAdaptees.add(new String[]{
                entry.getKey(),
                String.valueOf((int) entry.getValue()[0]),
                String.format("%.2f", entry.getValue()[1])
            });
            caTotal += entry.getValue()[1];
        }
    }

    @Override
    public List<String[]> getVentes() {
        return ventesAdaptees;
    }

    @Override
    public double getCiffreAffairesTotal() {
        return caTotal;
    }
}