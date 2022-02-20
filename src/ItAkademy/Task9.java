package ItAkademy;

import java.util.Arrays;

public class Task9 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 7, 9, 19,15};
        int[] b = new int[]{2, 4, 6, 8, 10, 11, 12, 13};
        int[] c = new int[a.length + b.length];
        int k = 5;
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            if (i == k) {
                for (int j = 0; j < b.length; j++){
                    c[count++]= b[j];
                }

            }
            c[count++]= a[i];
        }
        System.out.println(Arrays.toString(c));
    }
}

