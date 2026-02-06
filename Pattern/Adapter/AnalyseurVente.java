import java.util.List;

public interface AnalyseurVentes {
    List<String[]> getVentes();   // Retourne une liste de [nom, quantité, chiffreAffaires]
    double getCiffreAffairesTotal();
}
