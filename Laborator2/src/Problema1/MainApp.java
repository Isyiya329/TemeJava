package Problema1;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String[] judete = new String[41];
        int i = 0, poz = 0;
        Scanner scanner = new Scanner(new File("src/Problema1/judete_in.txt"));
        while(scanner.hasNext())
        {
            judete[i] = scanner.nextLine();
            i++;
        }
        Arrays.sort(judete);
        for(int j = 0; j < judete.length; j++)
        {
            System.out.println(judete[j]);
        }
        System.out.println("Introduceti judetul pe care doriti sa-l cautati: ");
        Scanner scanner1 = new Scanner(System.in);
        String judet = scanner1.nextLine();
        for (int j = 0; j < i; j++)
            if (judete[j].compareTo(judet) == 0)
                poz = j;
        System.out.println("Judetul pe care l-ati cautat este pe pozitia: " + poz);
    }
}

