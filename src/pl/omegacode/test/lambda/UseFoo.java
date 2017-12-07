package pl.omegacode.test.lambda;

import java.util.function.Function;

/**
 * @author kma 24 paź 2017
 */
public class UseFoo {

    public String add(String string, Function<String, String> fn) {
        return fn.apply(string);
    }
    
    public String add(String string, String b, Foo foo) {
        return foo.method(string, b);
    }

    public static void main(String[] args) {
        UseFoo useFoo = new UseFoo();
        Foo foo = (p, b) -> p + " from lambda " + b.toUpperCase() + " " + p.toLowerCase();
        Function<String, String> fn = 
                parameter -> parameter + " from lambda";
        String result = useFoo.add("Message ", fn);
        System.out.println(result);
        System.out.println(useFoo.add("Message", "second ", foo));
    }
}
