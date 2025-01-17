package Problema2;

public class Vers
{
    private String text;

    // Constructor
    public Vers(String text) {
        this.text = text;
    }

    // Metodă pentru a număra cuvintele din vers
    public int numarCuvinte() {
        if (text.trim().isEmpty()) {
            return 0;
        }
        return text.trim().split("\\s+").length;
    }

    // Metodă pentru a număra vocalele din vers
    public int numarVocale() {
        int count = 0;
        String lowerCaseText = text.toLowerCase();
        for (char c : lowerCaseText.toCharArray()) {
            if ("aeiouăîâeio".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    // Metodă pentru a verifica dacă versul se termină cu o grupare specificată
    public boolean seTerminaCu(String grupare) {
        return text.endsWith(grupare);
    }

    // Metodă pentru a converti textul în majuscule
    public void toUpperCase() {
        this.text = this.text.toUpperCase();
    }

    // Metodă pentru a obține textul versului
    public String getText() {
        return text;
    }

}
