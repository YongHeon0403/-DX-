package dx0421.set;

import java.util.HashSet;
import java.util.Set;

public class FindDupplication {
    public static void main(String[] args) {
        Set<String> s = new HashSet< >();   // HashSet 의 부모는 Set 이다.
        String[] sample = {"단어", "중복", "구절", "중복"};
        for (String a : sample)   // sample 안에 있는 값을 하나씩 꺼내서, a 라는 변수에 담아서 반복해라.
            if (!s.add(a))
                System.out.println("중복된 단어 " + a);
        System.out.println(s.size() + "중복되지 않은 단어: " + s);
    }
}
