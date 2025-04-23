package dx0423.stream;

import java.util.Arrays;
import java.util.List;

public class SortedTest {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("파인애플", "사과", "바나나", "귤");

        System.out.println("기본 정렬 (오름차순으로 정렬): ");

        fruits.stream()
                .sorted()
                .forEach(s-> System.out.println(s + " "));
        System.out.println();

        System.out.println("맞춤형 정렬 (문자열 길이에 따라 정렬): ");

        fruits.stream()
                .sorted((f1, f2) -> Integer.compare(f1.length(), f2.length()))    // 문자열 길이 기준으로 정렬
                .forEach(s -> System.out.println(s + " "));    // 정렬된 스트림을 하나씩 꺼내면서 출력
    }
}
