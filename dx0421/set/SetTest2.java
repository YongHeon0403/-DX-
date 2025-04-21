package dx0421.set;

import java.util.HashSet;
import java.util.Set;

public class SetTest2 {
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        s1.add("A");
        s1.add("B");
        s1.add("C");
        s2.add("A");
        s2.add("D");
        Set<String> union = new HashSet<>(s1);  // union 에 ABC 를 넣음.
        union.addAll(s2);   // s2 라는 집합(Set)에 들어 있는 모든 요소들을 union 이라는 집합에 한꺼번에 추가
        Set<String> intersection = new HashSet<>(s1);
        intersection.retainAll(s2);  // intersection 집합(Set)에서 s2에 없는 요소들은 모두 제거하고,
                                     // 공통으로 존재하는(겹치는) 요소만 남긴다.
        System.out.println("합집합 " + union);
        System.out.println("교집합 " + intersection);
    }
}
