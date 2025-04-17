package dx0417.GenericPPT;

class SimplePair<T> {
    private T apple;
    private T tomato;

    public SimplePair(T apple, T tomato) {
        this.apple = apple;
        this.tomato = tomato;
    }

    T getFirst() {  // 메서드 호출
        return apple;
    }
    T getSecond() { // 메서드 호출
        return tomato;
    }
}

    public class SimplePairTest {
    public static void main(String[] args) {
        SimplePair<String> pair = new SimplePair<String>("apple", "tomato");
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
    }
}
