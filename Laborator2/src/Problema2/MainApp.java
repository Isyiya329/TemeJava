package Problema2;

import java.io.*;
import java.util.Random;

public class MainApp
{
    public static void main(String[] args)
    {
        String inputFile = "src/Problema2/cantec_in.txt";
        String outputFile = "src/Problema2/cantec_out.txt";
        String grupareFinala = "as";
        Random random = new Random();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                Vers vers = new Vers(line);
                int numarCuvinte = vers.numarCuvinte();
                int numarVocale = vers.numarVocale();
                boolean terminaCuGrupare = vers.seTerminaCu(grupareFinala);

                if (random.nextDouble() < 0.1) {
                    vers.toUpperCase();
                }

                String outputLine = vers.getText() +
                        " Cuvinte: " + numarCuvinte +
                        " Vocale: " + numarVocale;

                if (terminaCuGrupare) {
                    outputLine += " *";
                }

                bw.write(outputLine);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Eroare la procesarea fisierelor: " + e.getMessage());
        }
    }

}
