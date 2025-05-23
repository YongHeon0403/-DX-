package dx0425.inputstream;

import java.io.IOException;

public class SystemInTest1 {
    public static void main(String[] args) {
        System.out.println("알파벳 하나를 쓰고 [Enter]를 누르세요.");

        int i;

        try {
            i = System.in.read();    // read() : 한 바이트 단위로 읽는 메서드
                                     // System.in : 키보드 입력
            System.out.println(i);
            System.out.println((char) i);    // 문자로 변환하여 출력
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
