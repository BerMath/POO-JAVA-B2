public class RemiseEtudiant extends Remise {
    public RemiseEtudiant() {
        super(0.1); // 10% de remise
    }

    @Override
    public String getTypeClient() {
        return "Étudiant";
    }
}