package dx0422.innerClass;

import com.sun.security.jgss.GSSUtil;
import dx0422.innerClassPPT.OuterClass;

class Outclass {
    private int num = 10;
    private static int sNum = 20;

    static class InStaticClass {
        int inNum = 100;
        static int sInNum = 200;

        void inTest() {
            System.out.println("InStaticClass inNum = " + inNum + "(내부 클래스의 인스턴스 변수 사용");
            System.out.println("InStaticClass sInNum = " + sInNum + "(내부 클래스의 정적 변수 사용)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 정적 변수 사용)");
        }

        static void sTest() {
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 정적 변수 사용)");
            System.out.println("InStaticClass sInNum = " + sInNum + "(내부 클래스의 정적 변수 사용)");
        }
    }
//    private InClass inClass;

//    public Outclass() {
//        inClass = new InClass();
//    }

//    class InClass {
//        int inNum = 100;
//        static int sInNum = 200;
//        void inTest() {
//            System.out.println("OutClass num = " + num + "(외부 클래스의 인스턴스 변수)");
//            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 정적 변수)");
//            System.out.println("OutClass sInNum = " + sInNum + "(인스턴스 내부 클래스의 정적 변수)");
//        }

//        static void sTest() {
//            System.out.println("인스턴스 내부 클래스의 정적 메서드 호출");
//        }
//    }
//    public void usingClass() {
//        inClass.inTest();
//    }
}


public class InnerClass {
    public static void main(String[] args) {
        Outclass.InStaticClass sInClass = new Outclass.InStaticClass();

        System.out.println("정적 내부 클래스 일반 메서드 호출");
        sInClass.inTest();

        System.out.println();

        System.out.println("정적 내부 클래스의 정적 메서드 호출");
        Outclass.InStaticClass.sTest();
//        Outclass outClass = new Outclass();

//        System.out.println("외부 클래스 이용하여 내부 클래스 기능 호출");
//        outClass.usingClass();
//        System.out.println("인스턴스 내부 클래스 정적 변수 직접 호출 OutClass.InClass.sInNum = " + Outclass.InClass.sInNum);
//        Outclass.InClass.sTest();
    }
}
