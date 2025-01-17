package Problema2;

import java.util.*;
import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class MainApp
{
    public static void scriere(List<PerecheNumere> lista) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("perechi.json"), lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PerecheNumere> citire() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File("perechi.json"), new TypeReference<List<PerecheNumere>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        List<PerecheNumere> lista = new ArrayList<>();
        lista.add(new PerecheNumere(8, 13));
        lista.add(new PerecheNumere(12, 18));
        lista.add(new PerecheNumere(22, 13));

        scriere(lista);
        List<PerecheNumere> listaCitita = citire();
        System.out.println("Lista citita:" + listaCitita);

        for (PerecheNumere pereche : listaCitita) {
            System.out.println("Pereche: " + pereche);
            System.out.println("Fibonacci: " + pereche.suntConsecutiveFibonacci());
            System.out.println("Cel mai mic multiplu comun: " + pereche.celMaiMicMultiplu());
            System.out.println("Suma cifrelor egala: " + pereche.auSumaCifrelorEgala());
            System.out.println("Numar egal de cifre pare: " + pereche.auAcelasiNumarDeCifrePare());
        }
    }
}
