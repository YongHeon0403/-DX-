package dx0421.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        String[] sample = {"i", "walk", "the", "line"};
        List<String> list = Arrays.asList(sample);   // 배열을 리스트로 변경
        Collections.sort(list);   // Collections : 리스트를 재정렬하는 메서드
        System.out.println(list);
    }
}
