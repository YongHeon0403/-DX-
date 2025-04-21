package dx0421.set;

import java.util.HashSet;

public class SetTest {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet< >(); // 랜덤으로 출력되고 중복을 허용하지 않음.
        set.add("Milk");
        set.add("Bread");
        set.add("Butter");
        set.add("Cheese");
        set.add("Ham");
        set.add("Ham");
    System.out.println(set);
    }
}