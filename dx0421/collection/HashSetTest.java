package dx0421.collection;

import java.util.HashSet;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(new String("임정순"));
        hashSet.add(new String("박현정"));
        hashSet.add(new String("홍연의"));
        hashSet.add(new String("강감찬"));
        hashSet.add(new String("강감찬"));

        System.out.println(hashSet);
        // HashSet 은 중복을 허용하지 않는 구조이기 때문에 '강감찬'이란 문자열이 한 번만 출력되고
        // ArrayList 는 추가한 순서대로 출력되지만 HashSet은 추가된 순서와 상관 없이 출력된다.
    }
}
