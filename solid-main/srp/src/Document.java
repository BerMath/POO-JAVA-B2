import java.time.LocalDate;

public class Document {
    private LocalDate date;
    private double montantHT;
    private double tva;
    private double totalTTC;
    private String clientName;
    private String type; // "FACTURE" ou "DEVIS"

    public Document(String type, double montantHT, String clientName) {
        this.type = type;
        this.date = LocalDate.now();
        this.montantHT = montantHT;
        this.clientName = clientName;
    }

    public Document(String type, double montantHT) {
        this(type, montantHT, null);
    }

    // Getters et setters
    public LocalDate getDate() { return date; }
    public double getMontantHT() { return montantHT; }
    public double getTva() { return tva; }
    public void setTva(double tva) { this.tva = tva; }
    public double getTotalTTC() { return totalTTC; }
    public void setTotalTTC(double totalTTC) { this.totalTTC = totalTTC; }
    public String getClientName() { return clientName; }
    public String getType() { return type; }
}