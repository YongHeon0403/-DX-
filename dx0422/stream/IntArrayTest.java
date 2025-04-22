package dx0422.stream;

import java.util.Arrays;

public class IntArrayTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        int sumVal = Arrays.stream(arr).sum();    // sum() : arr 배열 안에 저장된 값을 모두 더한다.
        int count = (int) Arrays.stream(arr).count();    // count() : arr 배열의 요소 개수를 반환한다.

        System.out.println(sumVal);
        System.out.println(count);
    }
}
