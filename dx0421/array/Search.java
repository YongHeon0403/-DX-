package dx0421.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Search {
    public static void main(String[] args) {
        int key = 50;
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<100; i++) {
            list.add(i);
        }

        int index = Collections.binarySearch(list, key);    // 정렬된 리스트에서 특정 값을 찾아 그 인덱스를 반환

        System.out.println("탐색의 반환값 : " + index);
    }
}
