package dx0425.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest2 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("C:\\Users\\USER\\Desktop\\YH\\java\\First\\src\\dx0425\\inputstream\\input.txt")) {
            int i;
            while ((i = fis.read()) != -1) {
                System.out.println((char) i);
            }
            System.out.println("end");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
