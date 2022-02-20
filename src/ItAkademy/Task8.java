package ItAkademy;

public class Task8 {
    public static void main(String[] args) {
        int[] a;
        int n = 5;
        a = new int[n];
        int k = 2;
        int sum = 0;


        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = 0; i < a.length; i++) {
            int num = a[i];
            if (num % k == 0) {
                sum = sum + num;
            }


        }
        System.out.println(sum);
    }


}
