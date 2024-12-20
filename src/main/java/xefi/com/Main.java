package xefi.com;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main{
    private static Scanner scanner = new Scanner(System.in);
    private static GestionDeComptes gestionComptes = new GestionDeComptes();

    public static void main(String[] args) {
        int choix;
        do {
            afficherMenu();
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    creerCompteCourant();
                    break;
                case 2:
                    creerCompteEpargne();
                    break;
                case 3:
                    crediterCompte();
                    break;
                case 4:
                    debiterCompte();
                    break;
                case 5:
                    effectuerVirement();
                    break;
                case 6:
                    gestionComptes.afficherComptes();
                    break;
                case 7:
                    gestionComptes.trierComptes();
                    gestionComptes.afficherComptes();
                    break;
                case 8:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Réessayez.");
            }
        } while (choix != 8);
    }

    private static void afficherMenu() {
        System.out.println("1. Créer un compte courant");
        System.out.println("2. Créer un compte épargne");
        System.out.println("3. Créditer un compte");
        System.out.println("4. Débiter un compte");
        System.out.println("5. Effectuer un virement");
        System.out.println("6. Afficher la liste des comptes");
        System.out.println("7. Trier les comptes");
        System.out.println("8. Quitter");
        System.out.print("Votre choix : ");
    }

    private static void creerCompteCourant() {
        System.out.print("Nom du compte : ");
        String nom = scanner.nextLine();
        System.out.print("Découvert autorisé : ");
        double decouvert = scanner.nextDouble();
        CompteCourant compte = new CompteCourant(nom, decouvert);
        gestionComptes.ajouterCompte(compte);
        System.out.println("Compte créé !");
    }

    private static void creerCompteEpargne() {
        System.out.print("Nom du compte : ");
        String nom = scanner.nextLine();
        System.out.print("Taux d'abondement : ");
        double taux = scanner.nextDouble() / 100;
        CompteEpargne compte = new CompteEpargne(nom, taux);
        gestionComptes.ajouterCompte(compte);
        System.out.println("Compte créé !");
    }

    private static void crediterCompte() {
        System.out.print("Compte à créditer : ");
        String nom = scanner.nextLine();
        System.out.print("Montant à créditer : ");
        double montant = scanner.nextDouble();

        for (Compte compte : gestionComptes.getComptes()) {
            if (compte.proprietaire.equals(nom)) {
                compte.crediter(montant);
                System.out.println("Compte crédité !");
                return;
            }
        }
        System.out.println("Compte non trouvé.");
    }

    private static void debiterCompte() {
        System.out.print("Compte à débiter : ");
        String nom = scanner.nextLine();
        System.out.print("Montant à débiter : ");
        double montant = scanner.nextDouble();

        for (Compte compte : gestionComptes.getComptes()) {
            if (compte.proprietaire.equals(nom)) {
                compte.debiter(montant);
                System.out.println("Compte débité !");
                return;
            }
        }
        System.out.println("Compte non trouvé.");
    }

    private static void effectuerVirement() {
        System.out.print("Compte à débiter : ");
        String nomDebiteur = scanner.nextLine();
        System.out.print("Compte à créditer : ");
        String nomCrediteur = scanner.nextLine();
        System.out.print("Montant du virement : ");
        double montant = scanner.nextDouble();

        Compte compteDebiteur = null;
        Compte compteCrediteur = null;

        for (Compte compte : gestionComptes.getComptes()) {
            if (compte.proprietaire.equals(nomDebiteur)) {
                compteDebiteur = compte;
            }
            if (compte.proprietaire.equals(nomCrediteur)) {
                compteCrediteur = compte;
            }
        }

        if (compteDebiteur != null && compteCrediteur != null) {
            compteDebiteur.debiter(montant, compteCrediteur);
            System.out.println("Virement effectué avec succès !");
        } else {
            System.out.println("Un des comptes n'a pas été trouvé.");
        }
    }
}