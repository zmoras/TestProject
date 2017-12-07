package pl.omegacode.test.generic;

/**
 * @author kma 28 paź 2017
 */
public class StandardBox<T> {
    static {
        System.out.println("StandardBox Static Block");
    }
    
    public static void test() {
        System.out.println("StandardBox constructor");
    }
    
    {
        System.out.println("StandardBox init");
    }

    public T object;

    public StandardBox(T object) {
        this.object = object;
    }

}
