package ItAkademy;

public class Task7 {
    public static void main(String[] args) {
        int a = 0;
        int b = 10;
        int h = 2;

        for (int x = a; x <= b; x = x + h) {
            double result = Math.pow( Math.sin(x),2) - Math.cos(2 * x);
            System.out.println(x + "   ||   "  + result);

        }
    }
}
