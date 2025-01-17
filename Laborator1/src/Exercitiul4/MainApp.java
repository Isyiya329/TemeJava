package Exercitiul4;

import java.util.Random;

public class MainApp
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        int r;
        int x = rand.nextInt(30);
        int y = rand.nextInt(30);
        System.out.println("Primul numar este:" + x);
        System.out.println("Al doilea numar este:" + y);
        while(y!=0)
        {
            r=x%y;
            x=y;
            y=r;
        }
        System.out.println(x);
    }
}
