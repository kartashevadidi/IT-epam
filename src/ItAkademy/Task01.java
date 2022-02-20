package ItAkademy;

public class Task01 {

        public static void main(String[] args) {
            int n = 2222;

            int a;
            int b;
            int c;
            int d;

            a = n % 10; // 4

            n = n / 10;

            b = n % 10; //3

            n = n / 10;

            c = n % 10; //2

            d = n / 10; //1

            if (a + b == d + c) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }


        }
    }


