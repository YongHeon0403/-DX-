package dx0421.collection;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<>();

        myList.add("A");
        myList.add("B");
        myList.add("C");

        System.out.println(myList);

        myList.add(1, "D");   // LinkedList 두 번째 위치에 D 추가
        System.out.println(myList);

        myList.addFirst("O");   // addFirst : LinkedList 맨 앞에 추가
        System.out.println(myList);

        System.out.println(myList.removeLast());    // removeLast : LinkedList 맨 뒤 요소 삭제 후 삭제된 요소 출력
        System.out.println(myList);
    }
}
