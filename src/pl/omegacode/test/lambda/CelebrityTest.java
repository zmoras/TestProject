package pl.omegacode.test.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author kma 24 paź 2017
 */
public class CelebrityTest {
    public static void main(String[] args) {
        List<Celebrity> celebrities = new ArrayList<Celebrity>(); //lista celebrytów
        celebrities.add(new Celebrity("Justin Bieber", true, false, true));
        celebrities.add(new Celebrity("Kim Kardashian", false, false, false));
        celebrities.add(new Celebrity("Joanna Krupa", true, true, false));
        print(celebrities, c -> c.canSing());//wyrażenie lambda
        print(celebrities, c -> c.canDance());//wyrażenie lambda

        new Thread(() -> System.out.println("Hello world!")).start();
        
        String[] animals = {"cat", "dog", "mouse", "rat", "pig", "rabbit", "hamster", "parrot"};
        Comparator<String> sortByName = (s1,s2) -> (s1.compareTo(s2));
        Arrays.sort(animals, sortByName);
        for (String string : animals) {
            System.out.println(string);
        }
    }

    private static void print(List<Celebrity> celebrities, Predicate<Celebrity> checker) { // interfejs Predicate
        for (Celebrity celebrity : celebrities) {
            if (checker.test(celebrity)) {
                System.out.println(celebrity + " ");
            }
            System.out.println();
        }

    }
}
