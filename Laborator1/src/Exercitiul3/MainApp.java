package Exercitiul3;

import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args) {
        int n, k = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dati un numar intreg: ");
        n = scanner.nextInt();
        for (int i = 1; i <= n; i++)
            if (n % i == 0)
            {
                System.out.println(i);
                k++;
            }
        if(k==2)
            System.out.println("Numarul dat este prim");

    }
}
