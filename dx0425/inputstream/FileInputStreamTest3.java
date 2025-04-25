package dx0425.inputstream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest3 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("C:\\Users\\USER\\Desktop\\YH\\java\\First\\src\\dx0425\\inputstream\\input2.txt")) {
            byte[] bs = new byte[10];
            int i;
            while ((i = fis.read(bs)) != -1) {
                for (byte b : bs) {
                    System.out.print((char) b);
                }
                /*
                for(int k=0; k<i; k++) {
                    System.out.print((char)bs[k]);
                }
                */
                System.out.println(": " + i + "바이트 읽음");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}

/* 출력 화면을 보면 마지막에 6바이트를 읽었는데 출력값은 Z 이후에 QRST 가 더 출력되었다.
   두 번째로 읽을 때 K~T 까지 10개 알파벳을 저장했다. 그러고 나서 마지막으로 U~Z 까지 저장할 때
   새로 읽어 들인 6개 외에 남은 4개 공간에는 기존 자료가 남아 있게 된다.
   이를 해결할려면 for 문을 위에 주석 처리된 코드로 바꾸면 된다. */