package Problema2;

public class PerecheNumere
{
    private int numar1;
    private int numar2;

    public PerecheNumere() {}

    public PerecheNumere(int numar1, int numar2) {
        this.numar1 = numar1;
        this.numar2 = numar2;
    }

    public int getNumar1() {
        return numar1;
    }

    public void setNumar1(int numar1) {
        this.numar1 = numar1;
    }

    public int getNumar2() {
        return numar2;
    }

    public void setNumar2(int numar2) {
        this.numar2 = numar2;
    }

    @Override
    public String toString() {
        return "(" + numar1 + ", " + numar2 + ")";
    }

    public boolean suntConsecutiveFibonacci() {
        return esteInFibonacci(numar1) && esteInFibonacci(numar2) &&
                Math.abs(indiceFibonacci(numar1) - indiceFibonacci(numar2)) == 1;
    }

    private boolean esteInFibonacci(int numar) {
        int a = 0, b = 1;
        while (b < numar) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b == numar || numar == 0;
    }

    private int indiceFibonacci(int numar) {
        int a = 0, b = 1, index = 1;
        while (b < numar) {
            int temp = b;
            b = a + b;
            a = temp;
            index++;
        }
        return numar == 0 ? 0 : index;
    }

    public int celMaiMicMultiplu() {
        return (numar1 * numar2) / cmmdc(numar1, numar2);
    }

    private int cmmdc(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public boolean auSumaCifrelorEgala() {
        return sumaCifrelor(numar1) == sumaCifrelor(numar2);
    }

    private int sumaCifrelor(int numar) {
        int suma = 0;
        while (numar != 0) {
            suma += numar % 10;
            numar /= 10;
        }
        return suma;
    }

    public boolean auAcelasiNumarDeCifrePare() {
        return numarDeCifrePare(numar1) == numarDeCifrePare(numar2);
    }

    private int numarDeCifrePare(int numar) {
        int count = 0;
        while (numar != 0) {
            if ((numar % 10) % 2 == 0) {
                count++;
            }
            numar /= 10;
        }
        return count;
    }
}
