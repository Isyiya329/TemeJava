package Problema3;

import java.util.Arrays;

public class Placa
{
    private String descriere;
    private int lungime;
    private int latime;
    private Orientare orientare;
    private boolean[] canturi;
    private int nrBucati;

    public enum Orientare
    {
        LUNGIME, LATIME, ORICARE
    }

    public Placa(String descriere, int lungime, int latime, Orientare orientare, boolean[] canturi, int nrBucati)
    {
        this.descriere = descriere;
        this.lungime = lungime;
        this.latime = latime;
        this.orientare = orientare;
        this.canturi = canturi;
        this.nrBucati = nrBucati;
    }

    public Placa()
    {

    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public int getLungime() {
        return lungime;
    }

    public void setLungime(int lungime) {
        this.lungime = lungime;
    }

    public int getLatime() {
        return latime;
    }

    public void setLatime(int latime) {
        this.latime = latime;
    }

    public Orientare getOrientare() {
        return orientare;
    }

    public void setOrientare(Orientare orientare) {
        this.orientare = orientare;
    }

    public boolean[] getCanturi() {
        return canturi;
    }

    public void setCanturi(boolean[] canturi) {
        this.canturi = canturi;
    }

    public int getNrBucati() {
        return nrBucati;
    }

    public void setNrBucati(int nrBucati) {
        this.nrBucati = nrBucati;
    }

    @Override
    public String toString()
    {
        return "Descriere: " + descriere + " Lungime: " + lungime + " Latime: " + latime + " Orientare: " + orientare + " Canturi: " + Arrays.toString(canturi) + " Numar bucati: " + nrBucati;
    }
}
