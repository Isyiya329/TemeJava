package Problema3;

import java.io.*;

public class MainApp
{
    public static void main(String[] args) {
        String inputFile = "src/Problema3/in.txt";
        String outputFile = "src/Problema3/out.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String initialString = br.readLine();
            if (initialString == null) {
                System.out.println("Fisier nu contine date");
                return;
            }

            String stringToInsert = br.readLine();
            int insertPosition = Integer.parseInt(br.readLine().trim());

            StringBuilder sb = new StringBuilder(initialString);
            if (insertPosition >= 0 && insertPosition <= sb.length()) {
                sb.insert(insertPosition, stringToInsert);
            } else {
                System.out.println("Pozitie invalida");
            }

            int deleteStart = Integer.parseInt(br.readLine().trim());
            int deleteLength = Integer.parseInt(br.readLine().trim());

            if (deleteStart >= 0 && deleteStart < sb.length() && deleteStart + deleteLength <= sb.length()) {
                sb.delete(deleteStart, deleteStart + deleteLength);
            } else {
                System.out.println("Interval invalid");
            }

            bw.write(sb.toString());
            bw.newLine();

            System.out.println("Operatiile au fost efectuate cu succes! ");

        } catch (IOException e) {
            System.err.println("Eroare la citirea sau scrierea fișierului: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Eroare de format a numerelor: " + e.getMessage());
        }
    }
}
