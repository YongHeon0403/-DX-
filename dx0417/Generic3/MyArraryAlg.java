package dx0417.Generic3;

public class MyArraryAlg {
    public static <T> T getLast(T[]a) { // language 의 길이는 3
        return a[a.length - 1];         // 3 - 1 = 2; 2번째 인덱스 값
    }                                   // JAVA 가 출력된다.

    public static <T> void swap(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
