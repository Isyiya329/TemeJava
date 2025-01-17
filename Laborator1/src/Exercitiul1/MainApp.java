package Exercitiul1;

import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dati lungimea dreptunghiului: ");
        int lungime = scanner.nextInt();
        System.out.println("Dati latimea dreptunghiului: ");
        int latime = scanner.nextInt();
        System.out.println("Perimetrul dreptunghiului este: " + (lungime+latime)*2);
        System.out.println("Aria dreptunghiului este: " + lungime * latime);
    }
}
