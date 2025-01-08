package main.java.com.Calculatrice;

import main.java.com.Calculatrice.operations.Addition;
import main.java.com.Calculatrice.operations.Division;
import main.java.com.Calculatrice.operations.Multiplication;
import main.java.com.Calculatrice.operations.Soustraction;
import main.java.com.Calculatrice.operations.RacineCarree;
import main.java.com.Calculatrice.operations.Puissance;

import java.util.Scanner;

public class CalculatriceApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOptions :");
            System.out.println("1. Addition");
            System.out.println("2. Soustraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Racine carrée");
            System.out.println("6. Puissance (x^y)");
            System.out.println("7. Quitter");

            System.out.print("Entrez votre choix : ");
            int choix = scanner.nextInt();

            if (choix == 7) {
                System.out.println("Au revoir !");
                break;
            }

            try {
                switch (choix) {
                    case 1 -> {
                        System.out.print("Entrez le premier nombre : ");
                        double a = scanner.nextDouble();
                        System.out.print("Entrez le second nombre : ");
                        double b = scanner.nextDouble();
                        System.out.println("Résultat : " + Addition.calculer(a, b));
                    }
                    case 2 -> {
                        System.out.print("Entrez le premier nombre : ");
                        double a = scanner.nextDouble();
                        System.out.print("Entrez le second nombre : ");
                        double b = scanner.nextDouble();
                        System.out.println("Résultat : " + Soustraction.calculer(a, b));
                    }
                    case 3 -> {
                        System.out.print("Entrez le premier nombre : ");
                        double a = scanner.nextDouble();
                        System.out.print("Entrez le second nombre : ");
                        double b = scanner.nextDouble();
                        System.out.println("Résultat : " + Multiplication.calculer(a, b));
                    }
                    case 4 -> {
                        System.out.print("Entrez le premier nombre : ");
                        double a = scanner.nextDouble();
                        System.out.print("Entrez le second nombre : ");
                        double b = scanner.nextDouble();
                        System.out.println("Résultat : " + Division.calculer(a, b));
                    }
                    case 5 -> {
                        System.out.print("Entrez un nombre : ");
                        double a = scanner.nextDouble();
                        System.out.println("Résultat : " + RacineCarree.calculer(a));
                    }
                    case 6 -> {
                        System.out.print("Entrez la base : ");
                        double a = scanner.nextDouble();
                        System.out.print("Entrez l'exposant : ");
                        double b = scanner.nextDouble();
                        System.out.println("Résultat : " + Puissance.calculer(a, b));
                    }
                    default -> System.out.println("Option invalide. Veuillez réessayer.");
                }
            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
            }
        }

        scanner.close();
    }
}