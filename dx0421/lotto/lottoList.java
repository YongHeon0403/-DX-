package dx0421.lotto;

import java.util.ArrayList;
import java.util.Collections;

public class lottoList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=1; i<46; i++) {
            list.add(i);
        }

        Collections.shuffle(list);
        for (int i=0; i<6; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}