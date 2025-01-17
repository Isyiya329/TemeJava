package Exercitiul1;

public class Parabola
{
    private int a, b, c;

    // Constructor
    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Metodă pentru a calcula și returna vârful parabolei
    public double[] getVarf() {
        double x = -b / (2.0 * a);
        double y = -((b * b) - 4 * a * c) / (4.0 * a);
        return new double[]{x, y};
    }

    // Suprascrierea metodei toString
    @Override
    public String toString() {
        return "f(x) = " + a + "x^2 + " + b + "x + " + c;
    }

    // Metodă statică pentru a calcula coordonatele mijlocului segmentului
    public static double[] calculeazaMijloc(Parabola p1, Parabola p2) {
        double[] varf1 = p1.getVarf();
        double[] varf2 = p2.getVarf();
        double x = (varf1[0] + varf2[0]) / 2;
        double y = (varf1[1] + varf2[1]) / 2;
        return new double[]{x, y};
    }

    // Metodă statică pentru a calcula lungimea segmentului dintre două vârfuri
    public static double calculeazaLungime(Parabola p1, Parabola p2) {
        double[] varf1 = p1.getVarf();
        double[] varf2 = p2.getVarf();
        return Math.hypot(varf2[0] - varf1[0], varf2[1] - varf1[1]);
    }
}
