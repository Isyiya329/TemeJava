package Exercitiul5;

import java.util.Random;

public class MainApp
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        int n = rand.nextInt(20);
        System.out.println("Numarul generat aleatoriu este " + n);
        int x=1, y=1, nr;
        boolean ok = false;
        if(n==x)
        {
            System.out.println("Numarul generat " + n + " apartine sirului Fibonnacci");
            ok = true;
        }
        while(y<=20)
        {
            nr=y;
            y=x+y;
            x=nr;
            if(n==y)
            {
                System.out.println("Numarul generat " + n + " apartine sirului Fibonnacci");
                ok=true;
            }
        }
        if(ok==false)
            System.out.println("Numarul generat " + n +  " nu apartine sirului Fibonnacci");

    }
}
