package dx0415.Final;

public class Constant {
    int num = 10;
    final int NUM = 100;

    public static void main(String[] args) {
        Constant cons = new Constant();
        cons.num = 50;
        //cons.NUM = 200;   // final로 상수로 지정해줬기 때문에 값 변경이 불가함으로 오류가 발생한다.

        System.out.println(cons.num);
        System.out.println(cons.NUM);
    }
}
