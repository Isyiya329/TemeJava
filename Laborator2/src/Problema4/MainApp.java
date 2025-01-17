package Problema4;

import java.time.LocalDate;
import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Numarul de persoane:");
        int n = Integer.parseInt(scanner.nextLine());

        Persoana[] persoane = new Persoana[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Numele: ");
            String nume = scanner.nextLine();

            String cnp;
            while (true) {
                System.out.println("CNP-ul: ");
                cnp = scanner.nextLine();
                if (validCNP(cnp)) {
                    break;
                } else {
                    System.out.println("CNP invalid. Introduceti din nou");
                }
            }

            persoane[i] = new Persoana(nume, cnp);
        }

        for (Persoana p : persoane) {
            System.out.println("Nume: " + p.getNume() + " CNP: " + p.getCnp() + " Varsta: " + p.getVarsta());
        }

        scanner.close();
    }

    private static boolean validCNP(String cnp) {
        if (cnp.length() != 13) {
            return false;
        }
        if (!cnp.matches("\\d+")) {
            return false;
        }
        char primaCifra = cnp.charAt(0);
        if (primaCifra != '1' && primaCifra != '2' && primaCifra != '5' && primaCifra != '6') {
            return false;
        }
        return cifraDeControl(cnp);
    }

    private static boolean cifraDeControl(String cnp) {
        int[] coeficienti = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int suma = 0;

        for (int i = 0; i < 12; i++) {
            suma += Character.getNumericValue(cnp.charAt(i)) * coeficienti[i];
        }

        int cifraControl = suma % 11;
        if (cifraControl == 10) {
            cifraControl = 1;
        }

        return cifraControl == Character.getNumericValue(cnp.charAt(12));
    }

}
