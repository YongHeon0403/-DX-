package dx0422.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.List;

public class LambdaEx5 {
    // 함수형 인터페이스를 사용하는 예제
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        // Supplier<T> : 매개 변수도 없고 반환값만 있다.
        Supplier<Integer> s = () -> (int)(Math.random()*100)+1;

        makeRandomList(s, list);
        System.out.println(list);

        Consumer<Integer> c = i -> System.out.print(i + ", ");
        Predicate<Integer> p = i -> i%2 == 0;

        printEvenNum(p, c, list);

        Function<Integer, Integer> f = i -> i/10*10;
        List<Integer> newList = doSomething(f, list);
    }

    static<T> List<T> doSomething(Function<T, T> f, List<T> list) {
        List<T> newList = new ArrayList<>(list.size());
        for (T i : list) {
            newList.add(f.apply(i));
        }
        return newList;
    }

    static<T> void makeRandomList(Supplier<T> s, List<T> list) {
        for (int i=0; i<10; i++) {
            list.add(s.get());
        }
    }


    static<T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for (T i : list) {
            if (p.test(i))      // 짝수이면 true
                c.accept(i);    // i + ", " 출력
        }
        System.out.print("]");
    }
}
