package dx0418.util;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("하나 ");
        list.add("둘 ");
        list.add("셋 ");
        list.add("넷 ");
        String s;
        Iterator e = list.iterator();
        while (e.hasNext()) {
            s = (String) e.next();  // 반복자는 Objecet 타입을 반환
            System.out.println(s);
        }
    }
}
