package Exercitiu;

public class Imprimante extends Echipament
{
    private int ppm;
    private int dpi;
    private int paginiCartus;
    private String modulTiparire;

    public Imprimante(String denumire, int nrInv, double pret, String zonaMag, Stare stare, int ppm, int dpi, int paginiCartus, String modulTiparire) {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.ppm = ppm;
        this.dpi = dpi;
        this.paginiCartus = paginiCartus;
        this.modulTiparire = modulTiparire;
    }

    public void setModulTiparire(String modulTiparire) {
        this.modulTiparire = modulTiparire;
    }

    @Override
    public String toString()
    {
        return "Imprimanta: " + super.getDenumire() + " PPM: " + ppm + " DPI: " + dpi + " Pagini Cartus: " + paginiCartus + " Tiparire: " + modulTiparire;
    }

}
