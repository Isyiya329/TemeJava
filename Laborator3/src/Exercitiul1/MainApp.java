package Exercitiul1;

import java.io.*;
import java.util.*;

public class MainApp
{
    public static void main(String[] args) {
        String inputFile = "src/Exercitiul1/in.txt";
        List<Parabola> parabole = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                int a = Integer.parseInt(parts[0]);
                int b = Integer.parseInt(parts[1]);
                int c = Integer.parseInt(parts[2]);
                parabole.add(new Parabola(a, b, c));
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea fisierului: " + e.getMessage());
        }

        for (Parabola p : parabole) {
            System.out.println(p);
            double[] varf = p.getVarf();
            System.out.printf("Vârf: (%.2f, %.2f)%n", varf[0], varf[1]);
        }

        if (parabole.size() >= 2) {
            Parabola p1 = parabole.get(0);
            Parabola p2 = parabole.get(1);

            double[] mijloc = Parabola.calculeazaMijloc(p1, p2);
            double lungime = Parabola.calculeazaLungime(p1, p2);

            System.out.printf("Mijlocul segmentului: (%.2f, %.2f)%n", mijloc[0], mijloc[1]);
            System.out.printf("Lungimea segmentului: %.2f%n", lungime);
        } else {
            System.out.println("Nu exista destule parabole pentru calcul.");
        }
    }
}
