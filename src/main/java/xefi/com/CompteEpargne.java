package xefi.com;

public class CompteEpargne extends Compte {
    private double tauxAbondement;

    public CompteEpargne(String proprietaire, double tauxAbondement) {
        super(proprietaire);
        this.tauxAbondement = tauxAbondement;
    }

    @Override
    public double calculBenefice() {
        return calculSolde() * tauxAbondement;
    }

    @Override
    public void information() {
        System.out.println("Propriétaire : " + proprietaire);
        System.out.printf("Solde : %.2f%n", soldeFinal());
        System.out.printf("Taux d'abondement : %.2f %%%n", tauxAbondement * 100);
        System.out.println("Opérations :");
        for (Operation op : operations) {
            System.out.println(op);
        }
    }
}
