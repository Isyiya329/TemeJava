package Exercitiul2;

import java.time.LocalDate;

public class Produs
{
    private String denumire;
    private double pret;
    private int cantitate;
    private LocalDate dataExpirare;
    public static double incasari = 0.0;

    // Constructor
    public Produs(String denumire, double pret, int cantitate, LocalDate dataExpirare) {
        this.denumire = denumire;
        this.pret = pret;
        this.cantitate = cantitate;
        this.dataExpirare = dataExpirare;
    }

    // Gettere și settere
    public String getDenumire() {
        return denumire;
    }

    public double getPret() {
        return pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public LocalDate getDataExpirare() {
        return dataExpirare;
    }

    @Override
    public String toString() {
        return "Denumire: " + denumire + " Pret: " + pret + " Cantitate: " + cantitate + " Data Expirare: " + dataExpirare;
    }
}
