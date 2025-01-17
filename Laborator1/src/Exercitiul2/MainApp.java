package Exercitiul2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.FileInputStream;
import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args)
    {
        try
        {
            Scanner scanner = new Scanner(new File("in.txt"));
            float s = 0, k = 0;
            int Max=Integer.MIN_VALUE, Min = Integer.MAX_VALUE;
            while(scanner.hasNext())
            {
                int x = Integer.parseInt(scanner.nextLine());
                s=s+x;
                if(Max<=x)
                    Max=x;
                if(Min>x)
                    Min=x;
                k++;
            }
            float mA = s/k;
            try
            {
                PrintStream flux_out = new PrintStream("out.txt");
                flux_out.println("Suma elementelor date este: " + s);
                flux_out.println("Media aritmetica a elementelor date este: " + mA);
                flux_out.println("Valoarea maxima a numerelor date este: " + Max);
                flux_out.println("Valoarea minima a numerelor date este: " + Min);
            }
            catch (FileNotFoundException e)
            {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}
