package Problema;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp
{
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        List<Angajat> angajati = loadEmployees(mapper);

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("1. Afiseaza lista angajatilor");
            System.out.println("2. Afiseaza angajatii cu salariu peste 2500 RON");
            System.out.println("3. Afiseaza angajatii din aprilie anul trecut în functii de conducere");
            System.out.println("4. Afiseaza angajatii fara functii de conducere, ordonati descrescator după salariu");
            System.out.println("5. Afiseaza numele angajatilor cu majuscule");
            System.out.println("6. Afiseaza salariile mai mici de 3000 RON");
            System.out.println("7. Afiseaza datele primului angajat al firmei");
            System.out.println("8. Afiseaza statistici referitoare la salarii");
            System.out.println("9. Verifica daca exista un angajat pe nume Ion");
            System.out.println("10. Afiseaza numarul de angajati din vara trecuta");
            System.out.println("0. Iesire");

            System.out.print("Alege o opțiune: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    angajati.forEach(System.out::println);
                    break;
                case 2:
                    angajati.stream()
                            .filter(angajat -> angajat.getSalariu() > 2500)
                            .forEach(System.out::println);
                    break;
                case 3:
                    int currentYear = LocalDate.now().getYear();
                    angajati.stream()
                            .filter(angajat -> angajat.getDataAngajarii().getYear() == currentYear - 1)
                            .filter(angajat -> angajat.getDataAngajarii().getMonthValue() == 4)
                            .filter(angajat -> angajat.getPost().toLowerCase().contains("sef") ||
                                    angajat.getPost().toLowerCase().contains("director"))
                            .forEach(System.out::println);
                    break;
                case 4:
                    angajati.stream()
                            .filter(angajat -> !angajat.getPost().toLowerCase().contains("sef") &&
                                    !angajat.getPost().toLowerCase().contains("director"))
                            .sorted(Comparator.comparing(Angajat::getSalariu).reversed())
                            .forEach(System.out::println);
                    break;
                case 5:
                    angajati.stream()
                            .map(angajat -> angajat.getNume().toUpperCase())
                            .forEach(System.out::println);
                    break;
                case 6:
                    angajati.stream()
                            .map(Angajat::getSalariu)
                            .filter(salariu -> salariu < 3000)
                            .forEach(System.out::println);
                    break;
                case 7:
                    angajati.stream()
                            .min(Comparator.comparing(Angajat::getDataAngajarii))
                            .ifPresentOrElse(System.out::println, () -> System.out.println("Nu există angajați."));
                    break;
                case 8:
                    DoubleSummaryStatistics stats = angajati.stream()
                            .collect(Collectors.summarizingDouble(Angajat::getSalariu));
                    System.out.println("Salariul mediu: " + stats.getAverage());
                    System.out.println("Salariul minim: " + stats.getMin());
                    System.out.println("Salariul maxim: " + stats.getMax());
                    break;
                case 9:
                    angajati.stream()
                            .map(Angajat::getNume)
                            .filter(nume -> nume.equalsIgnoreCase("Ion"))
                            .findAny()
                            .ifPresentOrElse(
                                    nume -> System.out.println("Firma are cel putin un Ion angajat."),
                                    () -> System.out.println("Firma nu are niciun Ion angajat."));
                    break;
                case 10:
                    long angajatiVara = angajati.stream()
                            .filter(angajat -> angajat.getDataAngajarii().getYear() == LocalDate.now().getYear() - 1)
                            .filter(angajat -> angajat.getDataAngajarii().getMonthValue() >= 6 &&
                                    angajat.getDataAngajarii().getMonthValue() <= 8)
                            .count();
                    System.out.println("Numarul de angajați din vara trecuta: " + angajatiVara);
                    break;
                case 0:
                    System.out.println("Iesire din program.");
                    break;
                default:
                    System.out.println("Optiune invalida. Incearca din nou.");
            }
        } while (option != 0);
    }

    private static List<Angajat> loadEmployees(ObjectMapper mapper) throws IOException {
        File file = new File("src/main/resources/angajati.json");
        return mapper.readValue(file, new TypeReference<List<Angajat>>() {});
    }

}
