package pl.omegacode.test.general;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author kma 28 paź 2017
 */
public class Test {
    public static void main(String... args) throws IOException {
        AverageTemperature reference1 = new AverageTemperature(123);
        AverageTemperature reference2 = reference1;
        System.out.println(reference1);
        System.out.println(reference2);
        reference2 = new AverageTemperature(3);
        System.out.println(reference1);
        System.out.println(reference2);

        System.out.println(new String("abc").equals("abc"));

        System.out.println(new String("abc") == "abc");

        System.out.println(new String("abc") == new String("abc"));

        System.out.println("abc" == "abc");

        System.out.println(reverse());
        System.out.println(fib(8));
        System.out.println(sum());
        System.out.println(odd());
        System.out.println(max());
        System.out.println("bin: " + (37 ^ 23));
        System.out.println("bin: shift " + (37 << 3));
        System.out.println("bin: shift right " + (37 >> 3));
        System.out.println("to bin " + (Integer.toBinaryString(18)));
    }

    public static String reverse() {
        String input = "nocojaniemoge";
        char[] t = input.toCharArray();
        int j = t.length - 1;
        char[] res = new char[t.length];
        for (int a = 0; a < t.length; a++) {
            res[a] = t[j--];
        }

        return String.valueOf(res);
    }

    public static int fib(int a) {
        if (a == 0) {
            return 0;
        }
        if (a == 1) {
            return 1;
        }
        return fib(a - 1) + fib(a - 2);

    }

    public static int sum() throws IOException {

        int sum = 0;
        try (BufferedReader in = new BufferedReader(new FileReader(new File("D:\\yhy.txt")))) {
            String a;
            while ((a = in.readLine()) != null) {
                int line;
                try {
                    line = Integer.valueOf(a);
                } catch (NumberFormatException e) {
                    System.out.println(a + " nie jest liczbą");
                    continue;
                }
                sum += line;
            }
        }

        return sum;
    }

    public static String odd() {
        String result = "";
        int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        for (int i : numbers) {
            if ((i & 1) == 1) {
                result += result.isEmpty() ? "odd: " + i : "," + i;
            }
        }
        return result;
    }

    public static int max() {
        int[] numbers = new int[] { 1, 2, 3, 4, 20, 5, 6, 7, 8, 9, 10 };
        int max = numbers[1];

        for (int i : numbers) {
            if (i >= max) {
                max = i;
            }
        }

        return max;
    }

}
