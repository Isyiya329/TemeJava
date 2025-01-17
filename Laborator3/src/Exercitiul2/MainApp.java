package Exercitiul2;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class MainApp
{
    public static void main(String[] args) {
        List<Produs> produse = new ArrayList<>();
        String inputFile = "src/Exercitiul2/produse.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String denumire = parts[0].trim();
                double pret = Double.parseDouble(parts[1].trim());
                int cantitate = Integer.parseInt(parts[2].trim());
                LocalDate dataExpirare = LocalDate.parse(parts[3].trim());
                produse.add(new Produs(denumire, pret, cantitate, dataExpirare));
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea fisierului: " + e.getMessage());
            return;
        }

        // Meniu interactiv
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nMeniu:");
            System.out.println("1. Afisarea tuturor produselor");
            System.out.println("2. Afisarea produselor expirate");
            System.out.println("3. Vanzarea unui produs");
            System.out.println("4. Afisarea produselor cu pret minim");
            System.out.println("5. Salvarea produselor cu cantitate mai mică decat o valoare");
            System.out.println("6. Iesire");
            System.out.print("Alege o optiune: ");
            int optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune) {
                case 1:
                    for (Produs produs : produse) {
                        System.out.println(produs);
                    }
                    break;

                case 2:
                    LocalDate azi = LocalDate.now();
                    for (Produs produs : produse) {
                        if (produs.getDataExpirare().isBefore(azi)) {
                            System.out.println(produs);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Denumirea produsului: ");
                    String denumire = scanner.nextLine();
                    System.out.print("Cantitatea dorita: ");
                    int cantitateDorita = scanner.nextInt();

                    Produs produsDeVandut = null;
                    for (Produs produs : produse) {
                        if (produs.getDenumire().equalsIgnoreCase(denumire)) {
                            produsDeVandut = produs;
                            break;
                        }
                    }

                    if (produsDeVandut != null) {
                        if (produsDeVandut.getCantitate() >= cantitateDorita) {
                            produsDeVandut.setCantitate(produsDeVandut.getCantitate() - cantitateDorita);
                            Produs.incasari += produsDeVandut.getPret() * cantitateDorita;
                            System.out.println("Produs s-a vandut cu succes!");
                            if (produsDeVandut.getCantitate() == 0) {
                                produse.remove(produsDeVandut);
                            }
                        } else {
                            System.out.println("Cantitate insuficienta pe stoc!");
                        }
                    } else {
                        System.out.println("Produsul nu exista în lista!");
                    }
                    break;

                case 4:
                    if (!produse.isEmpty()) {
                        double pretMinim = produse.get(0).getPret();
                        for (Produs produs : produse) {
                            if (produs.getPret() < pretMinim) {
                                pretMinim = produs.getPret();
                            }
                        }

                        for (Produs produs : produse) {
                            if (produs.getPret() == pretMinim) {
                                System.out.println(produs);
                            }
                        }
                    } else {
                        System.out.println("Lista de produse este goala.");
                    }
                    break;

                case 5:
                    System.out.print("Introduceti valoarea cantitatii: ");
                    int valoare = scanner.nextInt();
                    scanner.nextLine(); // Consumă linia rămasă
                    String outputFile = "src/Exercitiul2/produse_iesire.txt";

                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
                        for (Produs produs : produse) {
                            if (produs.getCantitate() < valoare) {
                                bw.write(produs.toString());
                                bw.newLine();
                            }
                        }
                    } catch (IOException e) {
                        System.err.println("Eroare la crearea fisierului: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Total incasari: " + Produs.incasari);
                    scanner.close();
                    return;

                default:
                    System.out.println("Optiune invalida!");
            }
        }
    }
}
