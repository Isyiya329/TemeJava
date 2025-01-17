package Problema3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainApp
{
    public static List<Mobilier> citireMobilier(String fisier) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(fisier), new TypeReference<List<Mobilier>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void afisareMobilier(List<Mobilier> listaMobilier) {
        for (Mobilier mobilier : listaMobilier) {
            System.out.println(mobilier);
        }
    }

    public static int calculeazaColiPal(List<Mobilier> listaMobilier) {
        int suprafataTotala = 0;
        for (Mobilier mobilier : listaMobilier) {
            for (Placa placa : mobilier.getPlaci()) {
                suprafataTotala += placa.getLungime() * placa.getLatime() * placa.getNrBucati();
            }
        }
        int suprafataColiiPal = 2800 * 2070;
        return (int) Math.ceil((double) suprafataTotala / suprafataColiiPal);
    }

    public static void main(String[] args) {

        String fisier = "mobilier.json";
        List<Mobilier> listaMobilier = citireMobilier(fisier);
        System.out.println("Lista pieselor de mobilier:");
        afisareMobilier(listaMobilier);
        int numarColi = calculeazaColiPal(listaMobilier);
        System.out.println("Numarul de coli de PAL necesare: " + numarColi);
    }
}
