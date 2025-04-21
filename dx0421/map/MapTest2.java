package dx0421.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class Word {
    String txt;

    public Word(String txt) {
        this.txt = txt;
    }

    public String toString() {
        return txt;
    }
}

public class MapTest2 {
    public static void main(String[] args) {
        Map<String, String> word = new HashMap<>();
        word.put("map", "지도");
        word.put("school", "학교");

        Scanner scan = new Scanner(System.in);

        do {
            System.out.print("영어 단어를 입력하시오: ");
            String key = scan.next();
            if (key.equals("quit"))
                break;
            System.out.println("단어의 의미는 : " + word.get(key));
        } while (true);
    }
}
