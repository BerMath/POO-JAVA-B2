import java.util.Arrays;
import java.util.List;

public class SandwichBuilder {

    final String pain;
    String viande;
    String fromage;
    List<String> legumes;
    String sauce;
    boolean grille;

    public SandwichBuilder(String pain) {
        this.pain = pain;
    }

    public SandwichBuilder viande(String viande)       { this.viande = viande;                  return this; }
    public SandwichBuilder fromage(String fromage)     { this.fromage = fromage;                return this; }
    public SandwichBuilder legumes(String... legumes)  { this.legumes = Arrays.asList(legumes); return this; }
    public SandwichBuilder sauce(String sauce)         { this.sauce = sauce;                    return this; }
    public SandwichBuilder grille(boolean grille)      { this.grille = grille;                  return this; }

    public Sandwich build() {
        return new Sandwich(this);
    }
}