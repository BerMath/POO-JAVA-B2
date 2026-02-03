import java.util.List;

public class Sandwich {

    private final String pain;
    private final String viande;
    private final String fromage;
    private final List<String> legumes;
    private final String sauce;
    private final boolean grille;

    Sandwich(SandwichBuilder b) {
        this.pain    = b.pain;
        this.viande  = b.viande;
        this.fromage = b.fromage;
        this.legumes = b.legumes;
        this.sauce   = b.sauce;
        this.grille  = b.grille;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "pain='" + pain + '\'' +
                (viande  != null ? ", viande='" + viande + '\'' : "") +
                (fromage != null ? ", fromage='" + fromage + '\'' : "") +
                (legumes != null ? ", légumes=" + legumes : "") +
                (sauce   != null ? ", sauce='" + sauce + '\'' : "") +
                ", grillé=" + grille +
                '}';
    }
}