package pl.omegacode.test.general;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kma
 * 22 paź 2017
 */
public abstract class Benchmark {

    final String name;

    public Benchmark(String name) {
        this.name = name;
    }

    abstract int run(int iterations) throws Throwable;

    private BigDecimal time() {
        try {
            int nextI = 1;
            int i;
            long duration;
            do {
                i = nextI;
                long start = System.nanoTime();
                run(i);
                duration = System.nanoTime() - start;
                nextI = (i << 1) | 1;
            } while (duration < 1000000000 && nextI > 0);
            return new BigDecimal((duration) * 1000 / i).movePointLeft(3);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return name + "\t" + time() + " ns";
    }

    public static void main(String[] args) throws Exception {
        final List<String> list = new ArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            list.add("a");
        }

        Benchmark[] marks = {
            new Benchmark("contains") {
                @Override
                int run(int iterations) throws Throwable {
                    for (int i = 0; i < iterations; i++) {
                        if (list.contains("b")) {
                            return 1;
                        }
                    }
                    return 0;
                }
            },
            new Benchmark("loop") {
                @Override
                int run(int iterations) throws Throwable {
                    for (int i = 0; i < iterations; i++) {
                        for (String s : list) {
                            if (s.equals("b")) {
                                return 1;
                            }
                        }
                    }
                    return 0;
                }
            }
        };

        for (Benchmark mark : marks) {
            System.out.println(mark);
        }
    }
}
