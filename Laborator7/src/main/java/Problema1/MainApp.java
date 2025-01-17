package Problema1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

record Carte(String titlu, String autor, int anAparitie)
{
    @Override
    public String toString()
    {
        return "Titlu: " + titlu + " Autor: " + autor + " Anul aparitiei: " + anAparitie;
    }
}
public class MainApp
{
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        File file = new File("src/main/resources/carti.json");
        Map<Integer, Carte> carti = mapper.readValue(file, new TypeReference<>() {});

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("1. Afiseaza colectia de carti");
            System.out.println("2. Sterge o carte dupa ID");
            System.out.println("3. Adauga o carte noua");
            System.out.println("4. Salveaza colectia in fisierul JSON");
            System.out.println("5. Creeaza o colectie de carti ale unui autor specificat");
            System.out.println("6. Afiseaza cartile ordonate alfabetic dupa titlu");
            System.out.println("7. Afișeaza cea mai veche carte");
            System.out.println("0. Iesire");

            System.out.print("Alege o opțiune: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consum newline

            switch (option) {
                case 1:
                    carti.forEach((id, carte) -> System.out.println(id + " -> " + carte));
                    break;
                case 2:
                    System.out.print("Introduce ID-ul cartii de sters: ");
                    int idToRemove = scanner.nextInt();
                    scanner.nextLine();
                    if (carti.remove(idToRemove) != null) {
                        System.out.println("Cartea a fost stearsa cu succes.");
                    } else {
                        System.out.println("Nu exista o carte cu acest ID.");
                    }
                    break;
                case 3:
                    System.out.print("Introduce ID-ul cartii: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Introduce titlul cartii: ");
                    String titlu = scanner.nextLine();
                    System.out.print("Introduce autorul cartii: ");
                    String autor = scanner.nextLine();
                    System.out.print("Introduce anul apariției: ");
                    int anAparitie = scanner.nextInt();
                    scanner.nextLine();
                    carti.putIfAbsent(id, new Carte(titlu, autor, anAparitie));
                    System.out.println("Cartea a fost adaugata.");
                    break;
                case 4:
                    mapper.writeValue(file, carti);
                    System.out.println("Colectia a fost salvata în fisierul JSON.");
                    break;
                case 5:
                    String autorCautat = "Yuval Noah Harari";
                    Set<Carte> cartiAutor = carti.values().stream()
                            .filter(carte -> carte.autor().equalsIgnoreCase(autorCautat))
                            .collect(Collectors.toSet());
                    System.out.println("Cartile autorului " + autorCautat + ":");
                    cartiAutor.forEach(System.out::println);
                    break;
                case 6:
                    carti.values().stream()
                            .sorted(Comparator.comparing(Carte::titlu))
                            .forEach(System.out::println);
                    break;
                case 7:
                    carti.values().stream()
                            .min(Comparator.comparing(Carte::anAparitie))
                            .ifPresentOrElse(System.out::println, () -> System.out.println("Nu exista carti."));
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opțiune invalida");
            }
        } while (option != 0);
    }
}
