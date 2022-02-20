package ItAkademy;

public class Task6 {
    public static void main(String[] args) {

        int a = 10;
        int b = 15;
        int c = 5;

        int min;
        int max;

        if (a < b) {
            min = a;
            max = b;
        } else {
            min = b;
            max = a;

        }

        if (c < min) {

            min = c;

        }
        if (c > max) {
            max = c;
        }

        System.out.println(min + max);


    }
}
