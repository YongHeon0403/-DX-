package dx0411.baeyeol;

import java.util.Scanner;

public class Array1 {
    public static void main(String[] args) {
        int s[] = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int value, index = -1;

        Scanner scan = new Scanner(System.in);
        System.out.print("탐색할 값을 입력하시오: ");
        value = scan.nextInt();

        for (int i=0; i < s.length; i++) {
            if (s[i] == value) {
                index = i;
                break;
            }
        }

        if (index < s.length && index >= 0)
            System.out.println("" + value + "값은" + index + "위치에 있습니다.");
    }
}
