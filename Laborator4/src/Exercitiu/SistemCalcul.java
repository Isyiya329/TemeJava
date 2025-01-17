package Exercitiu;

public class SistemCalcul extends Echipament
{
    private String tipMonitor;
    private double vitezaProcesor;
    private int capacitateHDD;
    private String sistemOperare;

    public SistemCalcul(String denumire, int nrInv, double pret, String zonaMag, Stare stare,
                        String tipMonitor, double vitezaProcesor, int capacitateHDD, String sistemOperare) {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.tipMonitor = tipMonitor;
        this.vitezaProcesor = vitezaProcesor;
        this.capacitateHDD = capacitateHDD;
        this.sistemOperare = sistemOperare;
    }

    public void setSistemOperare(String sistemOperare) {
        this.sistemOperare = sistemOperare;
    }

    @Override
    public String toString()
    {
        return "Sistem Calcul: " + super.getDenumire() + " Monitor: " + tipMonitor + " Procesor: " + vitezaProcesor + " GHZ" + " HDD: " + capacitateHDD + " OS: " + sistemOperare;
    }
}
