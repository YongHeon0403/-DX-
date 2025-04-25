package dx0425.outputstream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("C:\\Users\\USER\\Desktop\\YH\\java\\First\\src\\dx0425\\outputstream\\output2.txt", true);
        // FileOutputStream("output2.txt", true) true를 넣어주게 되면 값이 파일에 덮어쓰이지 않고 이어붙게 된다.
        try (fos) {
            byte[] bs = new byte[26];
            byte data = 65;
            for (int i=0; i<bs.length; i++) {
                bs[i] = data;
                data++;
            }
            fos.write(bs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("출력이 완료되었습니다.");
    }
}
