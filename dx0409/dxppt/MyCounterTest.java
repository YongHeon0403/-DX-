package dx0409.dxppt;

class MyCounter {
    int value = 0;

    void inc(MyCounter etr) {
        etr.value = etr.value + 1;
    }
}

public class MyCounterTest {
    public static void main(String[] args) {
        MyCounter obj = new MyCounter();

        System.out.println("obj.value=" + obj.value);
        obj.inc(obj);
        System.out.println("obj.value=" + obj.value);
    }
}
