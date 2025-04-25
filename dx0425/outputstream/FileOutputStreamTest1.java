package dx0425.outputstream;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest1 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("output.txt")) {
            fos.write(65);    // FileOutputStream 은
            fos.write(66);    // 파일에 숫자를 쓰면 해당하는 알파벳으로 변환된다.
            fos.write(67);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("출력이 완료되었습니다.");
    }
}
