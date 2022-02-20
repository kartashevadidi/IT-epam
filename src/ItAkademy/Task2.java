package ItAkademy;

public class Task2 {
    public static void main(String[] args) {
        double a = 1;
        double b = 2;
        double c = 5;
        double result;

        double part1 = (b + (Math.sqrt(Math.pow(b, 2) + (4 * a * c))));
        double part2 = part1 / (2 * a);
        double part3 = Math.pow(a, 3) * c + Math.pow(b,-2);
        result = part2 - part3;
        System.out.println(result);
    }
}
