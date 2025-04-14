package dx0411.baeyeol;

import java.sql.SQLOutput;

public class ArraryTest {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        int y = 0;


        for (int i=0; i < arr.length; i++) {
            y++;
            for (int j=0; j < arr.length; j++) {
                if (i == j) {
                    System.out.print(y);
                } else
                    System.out.print("*");
            }
            System.out.println("");
        }
    }
}
