package pl.omegacode.test.general;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author kma 28 paź 2017
 */
public class MyContextManager implements AutoCloseable, Serializable {
    private static final long serialVersionUID = -2022448139317277938L;

    public MyContextManager() {
        System.out.println("Wlasnie sie tworze!");
    }

    public void doSomething() {
        System.out.println("Wlasnie cos robie :)");
    }

    public void close() {
        System.out.println("Ktos mnie teraz zamyka!");
    }
    
    private static void localClassInstantiation(String[] args) {
        class LocalClass {
            @Override
            public String toString() {
                return "Argumenty metody: " + Arrays.toString(args);
            }
        }   
        LocalClass localClassInstance = new LocalClass();
        System.out.println(localClassInstance);
    }

    public static void main(String[] args) {
        try (MyContextManager manager = new MyContextManager()) {
            manager.doSomething();
        }
        
        localClassInstantiation(new String[]{"a","b","c"});

        MyContextManager man = new MyContextManager();
        MyContextManager.MyContextManagerMain main = man.new MyContextManagerMain();
        main.dos();
        
        MyContextManager.MyContextManagerMainS mainS = new MyContextManager.MyContextManagerMainS();
        
        
        new GreetingModule() {
            @Override
            public void sayHello() {
                System.out.println("good morning");
            }
        };

    }

    public class MyContextManagerMain {
        void dos() {
            doSomething();
            close();
        }

    }

    public static class MyContextManagerMainS {
        void dos() {
        }

    }

}
