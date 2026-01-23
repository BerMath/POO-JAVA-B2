import java.io.FileWriter;
import java.io.IOException;

public class SauvegardeDocument {

    public void sauvegarder(Document document) {
        String nomFichier = document.getType().toLowerCase() + "s.txt";
        
        try (FileWriter writer = new FileWriter(nomFichier, true)) {
            writer.write(formatLigne(document));
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }

    private String formatLigne(Document document) {
        StringBuilder ligne = new StringBuilder();
        ligne.append(document.getType()).append(" | ");
        ligne.append(document.getDate()).append(" | ");
        
        if (document.getClientName() != null) {
            ligne.append("Client=").append(document.getClientName()).append(" | ");
        }
        
        ligne.append("HT=").append(document.getMontantHT()).append(" | ");
        ligne.append("TVA=").append(document.getTva()).append(" | ");
        ligne.append("TTC=").append(document.getTotalTTC());
        
        if (document.getType().equals("DEVIS")) {
            ligne.append(" | validite=30j");
        }
        
        ligne.append("\n");
        return ligne.toString();
    }
}