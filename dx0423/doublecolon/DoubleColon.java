package dx0423.doublecolon;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class DoubleColon {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("first", "second", "third", "forth");
        list.forEach(item -> System.out.println(item));
        System.out.println("-----------");
        list.forEach(System.out::println);  // list.forEach(s -> System.out.println(s));
    }


}
