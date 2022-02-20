package ItAkademy;

public class Task3 {
    public static void main(String[] args) {
        double a = 5;
        double b = 10;
        double g;
        double p;
        double sq;


        g = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        p = a + b + g;


        sq = (a * b) / 2;

        System.out.println( "Площадь: "+  sq);
        System.out.println("Периметр: " + p);

    }
}
