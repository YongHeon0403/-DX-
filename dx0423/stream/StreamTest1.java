package dx0423.stream;

import java.util.stream.IntStream;

public class StreamTest1 {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(1, 5);
        intStream.forEach(System.out::println);
        System.out.println("----------------------");
        IntStream intStream1 = IntStream.rangeClosed(1, 5);
        intStream1.forEach(System.out::println);
    }
}
