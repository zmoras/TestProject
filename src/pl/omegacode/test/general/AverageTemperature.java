package pl.omegacode.test.general;

import java.util.Scanner;

/**
 * @author kma
 * 28 paź 2017
 */
public class AverageTemperature {
    int value;
    public AverageTemperature(int i) {
        this.value = i;
    }

    public static void main(String... args) {
        double[] temperature = new double[7];
        Scanner inputScanner = new Scanner(System.in);
 
        for(int i = 0; i < temperature.length; i++) {
            System.out.println("Wprowadź liczbę " + i);
            temperature[i] = inputScanner.nextDouble();
        }
 
        double summarizedTemp = 0;
        for (double temp : temperature) {
            summarizedTemp += temp;
        }
 
        System.out.println("Średnia temperatura wynosi " + (summarizedTemp / temperature.length));
    }
}