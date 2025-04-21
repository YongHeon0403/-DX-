package dx0421.collection;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();   // 중복을 허용하지 않으면서 출력 결괏값을 정렬하는 클래스

        treeSet.add("홍길동");
        treeSet.add("강감찬");
        treeSet.add("이순신");

        for (String str : treeSet) {
            System.out.println(str);
        }
    }
}
