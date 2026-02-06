import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LecteurCSV {

    private final String cheminFichier;

    public LecteurCSV(String cheminFichier) {
        this.cheminFichier = cheminFichier;
    }

    
    public List<String[]> lire() {
        List<String[]> lignes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            reader.readLine(); // on saute l'en-tête
            while ((ligne = reader.readLine()) != null) {
                if (!ligne.trim().isEmpty()) {
                    lignes.add(ligne.split(";"));
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lecture fichier : " + e.getMessage());
        }
        return lignes;
    }
}
