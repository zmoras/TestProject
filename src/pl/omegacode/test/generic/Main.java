package pl.omegacode.test.generic;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author kma 28 paź 2017
 */
public class Main {

    private static void method1(FancyBox<?> box) {
        Object object = box.object;
        System.out.println(object);
    }

    public static void main(String[] args) throws IOException {
        
        StandardBox<String> standard = new StandardBox<String>("a");
        FancyBox<String> fancy = new FancyBox<String>("b");
        standard.test();
        fancy.test();
        
        FancyBox<Integer> box = new FancyBox<>(Integer.valueOf("2"));
        box.saySomethingFancy();

        method1(new FancyBox<String>("a"));
        method1(new FancyBox<Integer>(3));
        method1(new FancyBox<Boolean>(true));

        String str = "knowledge";
        String a = str;
        str = str.concat(" base");
        System.out.println(str);

        System.out.println("10 == 10: " + (10 == 10));
        System.out.println("10 != 10: " + (10 != 10));
        System.out.println("true == true: " + (true == true));
        System.out.println("true != true: " + (true != true));
        System.out.println("'a' == 'a': " + ('a' == 'a'));
        System.out.println("'a' != 'a': " + ('a' != 'a'));
        System.out.println("500L == 500L: " + (500L == 500L));
        System.out.println("5" + "00L != 500L: " + (500L != 500L));

        writeFile();
        writeFileBinary();
        readFileBinary();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File("D://yhy.txt")));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);

            }
        } finally {
            if (br != null) {
                br.close();
            }
        }

    }

    static void writeFile() throws IOException {
        String filePath = "D://yhy.txt";
        int number = 1234567;
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath);
            fileWriter.write(Integer.toString(number));
        } finally {
            if (fileWriter != null) {
                fileWriter.flush();
                fileWriter.close();
            }
        }
    }

    static void writeFileBinary() throws IOException {
        String filePath = "D://yhy2.txt";
        int number = 1234567;
        DataOutputStream outputStream = null;

        try {
            outputStream = new DataOutputStream(new FileOutputStream(filePath));
            outputStream.writeInt(number);
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    static void readFileBinary() throws IOException {
        String filePath = "D://yhy2.txt";
        int number = 0;

        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(filePath))) {
            number = inputStream.readInt();
            System.out.println("num " + number);
        }
    }
}
