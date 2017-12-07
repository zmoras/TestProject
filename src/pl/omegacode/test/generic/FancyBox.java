package pl.omegacode.test.generic;

/**
 * @author kma
 * 28 paź 2017
 */
public class FancyBox<T> extends StandardBox<T> {
    
    public static void test() {
        System.out.println("FancyBox");
    }

    public FancyBox(T object) {
        super(object);
    }
    
    public void saySomethingFancy() {
        System.out.println("our " + object + " is cool!");
    }

}
