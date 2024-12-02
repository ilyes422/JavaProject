package xefi.com;

public class CompteCourant extends Compte {
    private double decouvertAutorise;

    public CompteCourant() {}

    public CompteCourant(String proprietaire, double decouvertAutorise) {
        super(proprietaire);
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public double calculBenefice() {
        return 0;
    }

    @Override
    public void information() {
        System.out.println("*******************************************");
        System.out.println("Propriétaire : " + proprietaire);
        System.out.printf("Solde : %.2f%n", calculSolde());
        System.out.printf("Découvert autorisé : %.2f%n", decouvertAutorise);
        System.out.println("Opérations :");
        for (Operation op : operations) {
            System.out.println(op);
        }
        System.out.println("*******************************************");
    }
}