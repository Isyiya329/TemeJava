package Exercitiu;

import java.io.*;
import java.util.*;

 enum Stare
{
    ACHIZITIONAT, EXPUS, VANDUT
}

public class MainApp
{
    private static List<Echipament> echipamente = new ArrayList<>();

    public static void main(String[] args) {
        citireDinFisier("echipamente.txt");
        Scanner scanner = new Scanner(System.in);
        int optiune;
        do {
            System.out.println("\nMeniu:");
            System.out.println("1. Afisare toate echipamentele");
            System.out.println("2. Afisare imprimante");
            System.out.println("3. Afisare copiatoare");
            System.out.println("4. Afisare sisteme de calcul");
            System.out.println("5. Modificare stare echipament");
            System.out.println("6. Setare mod tiparire imprimanta");
            System.out.println("7. Setare format copiere copiator");
            System.out.println("8. Instalare OS pe sistem calcul");
            System.out.println("9. Afisare echipamente vandute");
            System.out.println("0. Iesire");
            System.out.print("Alegeti optiunea: ");
            optiune = scanner.nextInt();

            switch (optiune) {
                case 1:
                    afisareEchipamente();
                    break;
                case 2:
                    afisareImprimante();
                    break;
                case 3:
                    afisareCopiatoare();
                    break;
                case 4:
                    afisareSistemeCalcul();
                    break;
                case 5:
                    modificareStare(scanner);
                    break;
                case 6:
                    setareModTiparire(scanner);
                    break;
                case 7:
                    setareFormatCopiere(scanner);
                    break;
                case 8:
                    instalareOS(scanner);
                    break;
                case 9:
                    afisareEchipamenteVandute();
                    break;
                case 0:
                    System.out.println("Iesire din aplicatie.");
                    break;
                default:
                    System.out.println("Optiune invalida!");
            }
        } while (optiune != 0);
        scanner.close();
    }

    private static void citireDinFisier(String numeFisier) {
        try (BufferedReader br = new BufferedReader(new FileReader(numeFisier))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                String[] valori = linie.split("\\s+");
                String tip = valori[0];
                String denumire = valori[1];
                int nrInv = Integer.parseInt(valori[2]);
                double pret = Double.parseDouble(valori[3]);
                String zonaMag = valori[4];
                Stare stare = Stare.valueOf(valori[5].toUpperCase());

                switch (tip) {
                    case "Imprimanta":
                        int ppm = Integer.parseInt(valori[6]);
                        int dpi = Integer.parseInt(valori[7]);
                        int paginiCartus = Integer.parseInt(valori[8]);
                        String modulTiparire = valori[9];
                        echipamente.add(new Imprimante(denumire, nrInv, pret, zonaMag, stare, ppm, dpi, paginiCartus, modulTiparire));
                        break;
                    case "Copiator":
                        int paginiToner = Integer.parseInt(valori[6]);
                        String formatCopiere = valori[7];
                        echipamente.add(new Copiator(denumire, nrInv, pret, zonaMag, stare, paginiToner, formatCopiere));
                        break;
                    case "SistemCalcul":
                        String tipMonitor = valori[6];
                        double vitezaProcesor = Double.parseDouble(valori[7]);
                        int capacitateHDD = Integer.parseInt(valori[8]);
                        String sistemOperare = valori[9];
                        echipamente.add(new SistemCalcul(denumire, nrInv, pret, zonaMag, stare, tipMonitor, vitezaProcesor, capacitateHDD, sistemOperare));
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea fisierului: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Eroare la conversia numerelor din fisier: " + e.getMessage());
        }
    }

    private static void afisareEchipamente() {
        for (Echipament e : echipamente) {
            System.out.println(e.toString());
        }
    }

    private static void afisareImprimante() {
        for (Echipament e : echipamente) {
            if (e instanceof Imprimante) {
                System.out.println(e.toString());
            }
        }
    }

    private static void afisareCopiatoare() {
        for (Echipament e : echipamente) {
            if (e instanceof Copiator) {
                System.out.println(e.toString());
            }
        }
    }

    private static void afisareSistemeCalcul() {
        for (Echipament e : echipamente) {
            if (e instanceof SistemCalcul) {
                System.out.println(e.toString());
            }
        }
    }

    private static void modificareStare(Scanner scanner) {
        System.out.print("Introduceti numarul de inventar: ");
        int nrInv = scanner.nextInt();
        System.out.print("Introduceti noua stare (ACHIZITIONAT, EXPUS, VANDUT): ");
        Stare stare = Stare.valueOf(scanner.next().toUpperCase());

        for (Echipament e : echipamente) {
            if (e.getNrInv() == nrInv) {
                e.setStare(stare);
                break;
            }
        }
    }

    private static void setareModTiparire(Scanner scanner) {
        System.out.print("Introduceti numarul de inventar: ");
        int nrInv = scanner.nextInt();
        System.out.print("Introduceti modul de tiparire (alb negru, color): ");
        String mod = scanner.next();

        for (Echipament e : echipamente) {
            if (e instanceof Imprimante && e.getNrInv() == nrInv) {
                ((Imprimante) e).setModulTiparire(mod);
                break;
            }
        }
    }

    private static void setareFormatCopiere(Scanner scanner) {
        System.out.print("Introduceti numarul de inventar: ");
        int nrInv = scanner.nextInt();
        System.out.print("Introduceti formatul de copiere (A3, A4): ");
        String format = scanner.next();

        for (Echipament e : echipamente) {
            if (e instanceof Copiator && e.getNrInv() == nrInv) {
                ((Copiator) e).setFormatCopiere(format);
                break;
            }
        }
    }

    private static void instalareOS(Scanner scanner) {
        System.out.print("Introduceti numarul de inventar: ");
        int nrInv = scanner.nextInt();
        System.out.print("Introduceti sistemul de operare (Windows, Linux): ");
        String os = scanner.next();

        for (Echipament e : echipamente) {
            if (e instanceof SistemCalcul && e.getNrInv() == nrInv) {
                ((SistemCalcul) e).setSistemOperare(os);
                break;
            }
        }
    }

    private static void afisareEchipamenteVandute() {
        for (Echipament e : echipamente) {
            if (e.getStare() == Stare.VANDUT) {
                System.out.println(e.toString());
            }
        }
    }
}
