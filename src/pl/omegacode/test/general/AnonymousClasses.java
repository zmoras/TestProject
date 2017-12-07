package pl.omegacode.test.general;

/**
 * @author kma 28 paź 2017
 */
public class AnonymousClasses {
    public static class Robot {
        private final GreetingModule greetingModule;

        public Robot(GreetingModule greetingModule) {
            this.greetingModule = greetingModule;
        }

        public void saySomething() {
            greetingModule.sayHello();
            greetingModule.yes();
        }
    }

    public interface GreetingModule {
        void sayHello();

        void yes();
    }

    public static void main(String[] args) {
        Robot jan = new Robot(new GreetingModule() {
            @Override
            public void sayHello() {
                System.out.println("dzien dobry");
            }

            @Override
            public void yes() {

            }
        });
        Robot john = new Robot(new GreetingModule() {
            @Override
            public void sayHello() {
                System.out.println("good morning");
            }

            @Override
            public void yes() {
                System.out.println("yes");

            }
        });

        jan.saySomething();
        john.saySomething();
    }
}
