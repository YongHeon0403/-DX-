package dx0423.stream;

import dx0418.util.LinkedListTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectTest {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = x -> x > 0;

        List<Integer> numbers = Arrays.asList(5, -10, -22, 0, 43, 7);

        List<Integer> positiveNumbers = numbers.stream()
                .filter(isPositive)
                .collect(Collectors.toList());    // 중간 연산한 스트림의 결과를 다시 리스트로 반환받아 활용할 수 있다.
        System.out.println(positiveNumbers);    // collect()를 사용해 리스트로 반환받아서 출력
    }
}
