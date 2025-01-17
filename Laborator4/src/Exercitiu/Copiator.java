package Exercitiu;

public class Copiator extends Echipament
{
    private int paginiToner;
    private String formatCopiere;

    public Copiator(String denumire, int nrInv, double pret, String zonaMag, Stare stare,  int paginiToner, String formatCopiere)
    {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.paginiToner = paginiToner;
        this.formatCopiere = formatCopiere;
    }

    public void setFormatCopiere(String formatCopiere) {
        this.formatCopiere = formatCopiere;
    }

    @Override
    public String toString()
    {
        return "Copiator: " + super.getDenumire() + " Pagini / Toner: " + paginiToner + "Format: " + formatCopiere;
    }
}
