package Exercitiu;


public class Echipament
{
    private String denumire;
    private int nrInv;
    private double pret;
    private String zonaMag;
    private Stare stare;

    public Echipament(String denumire, int nrInv, double pret, String zonaMag, Stare stare) {
        this.denumire = denumire;
        this.nrInv = nrInv;
        this.pret = pret;
        this.zonaMag = zonaMag;
        this.stare = stare;
    }

    public String getDenumire() {
        return denumire;
    }

    public int getNrInv() {
        return nrInv;
    }

    public double getPret() {
        return pret;
    }

    public String getZonaMag() {
        return zonaMag;
    }

    public Stare getStare() {
        return stare;
    }

    public void setStare(Stare stare) {
        this.stare = stare;
    }

    @Override
    public String toString()
    {
        return "Echipament: " + denumire + " Nr. Inv: " + nrInv + " Pret: " + pret + " Zona: " + zonaMag + " Stare: " + stare;
    }
}
