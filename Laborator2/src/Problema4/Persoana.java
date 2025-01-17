package Problema4;

import java.time.LocalDate;

public class Persoana
{
    private String nume;
    private String cnp;

    // Constructor
    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }

    // Getter pentru nume
    public String getNume() {
        return nume;
    }

    // Getter pentru CNP
    public String getCnp() {
        return cnp;
    }

    // Calcularea vârstei manual
    public int getVarsta() {
        int anulNasterii = Integer.parseInt(cnp.substring(1, 3));
        int lunaNasterii = Integer.parseInt(cnp.substring(3, 5));
        int ziuaNasterii = Integer.parseInt(cnp.substring(5, 7));

        // Determinarea secolului din prima cifră a CNP-ului
        int secol = (cnp.charAt(0) == '1' || cnp.charAt(0) == '2') ? 1900 : 2000;
        anulNasterii += secol;

        // Data curentă
        LocalDate dataCurenta = LocalDate.now();
        int anulCurent = dataCurenta.getYear();
        int lunaCurenta = dataCurenta.getMonthValue();
        int ziuaCurenta = dataCurenta.getDayOfMonth();

        // Calcularea vârstei
        int varsta = anulCurent - anulNasterii;

        if (lunaCurenta < lunaNasterii || (lunaCurenta == lunaNasterii && ziuaCurenta < ziuaNasterii)) {
            varsta--; // Ajustare dacă ziua de naștere nu a fost încă în anul curent
        }

        return varsta;
    }

}
