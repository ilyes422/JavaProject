package xefi.com;

public class Operation {
    private double montant;
    private Mouvement type;

    public Operation(double montant, Mouvement type) {
        this.montant = montant;
        this.type = type;
    }

    public double getMontant() {
        return montant;
    }

    public Mouvement getType() {
        return type;
    }

    @Override
    public String toString() {
        return (type == Mouvement.CREDIT ? "+" : "-") + String.format("%.2f", montant);
    }
}
