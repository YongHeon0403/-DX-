package dx0423.stream;

import java.util.Arrays;
import java.util.function.BinaryOperator;

class CompareString implements BinaryOperator<String> {
    @Override
    public String apply(String s1, String s2) {
        if (s1.getBytes().length >= s2.getBytes().length) return s1;
        else return s2;
    }
    // getBytes()를 사용하는 이유 : 한글은 UTF-8에서 보통 한 글자당 2~3바이트이다.
    //                            따라서 글자 수가 아닌 실제 바이트 길이 기준으로 비교할 수 있다.
}

public class ReduceTest {
    public static void main(String[] args) {
        String[] greetings = {"안녕하세요~~~", "hello", "Good morning", "반갑습니다^^"};
        System.out.println(Arrays.stream(greetings).reduce("", (s1, s2) -> {
            if (s1.getBytes().length >= s2.getBytes().length)
                return s1;
            else return s2;
        }));
    }
}
