package dx0422.lambda;

@FunctionalInterface    // 컴파일러가 함수형 인터페이스를 올바르게 정의하였는지 확인한다.
interface MyFunction {
    void run();
}

public class LambdaEx2 {    // Myfunction f = () -> System.out.println("f1.run()");
    static void execute(MyFunction f) {
        f.run();
    }
    static MyFunction getMyFunction() {
        MyFunction f = () -> System.out.println("f3.run()");
        return f;
    }

    public static void main(String[] args) {
        // 람다식으로 MyFunction 의 run() 을 구현
        MyFunction f1 = () -> System.out.println("f1.run()");
        f1.run();

        // 익명 클래스로 run() 을 구현
        MyFunction f2 = new MyFunction() {
            @Override
            public void run() {
                System.out.println("f2.run()");
            }
        };
        f2.run();

        // 람다식으로 MyFunction 을 구현한 메서드로 run() 을 구현
        MyFunction f3 = getMyFunction();
        f3.run();


        execute(f1);
        execute(() -> System.out.println("run()"));
    }
}
