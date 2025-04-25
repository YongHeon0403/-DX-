package dx0425.inputstream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest1 {
    public static void main(String[] args) {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("dx0425/inputstream/input.txt");

            System.out.println(fis.read());
            System.out.println(fis.read());
            System.out.println(fis.read());

            /* 출력이 되게 하려면 어떻게 ? */
            /* fis = new FileInputStream("C:\\Temp\\input.txt"); - 실제로 파일을 만들어주고 경로를 적는다.

               System.out.println((char)fis.read()); - (char)로 형변환을 시키고 출력한다.
               System.out.println((char)fis.read()); - read()가 int 타입이기 때문에 char 로 형변환을 해줘야 한다.
               System.out.println((char)fis.read()); */

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println(e);
            } catch (NullPointerException e) {
                System.out.println(e);
            }
        }
        System.out.println("end");
    }
}
