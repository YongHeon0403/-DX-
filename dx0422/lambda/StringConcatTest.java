package dx0422.lambda;

public class StringConcatTest {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "World";

        StringConCatImpl concat1 = new StringConCatImpl();
        concat1.makeString(s1, s2);

        StringConcat concat2 = (s, v) -> System.out.println(s + "," + v);
        concat2.makeString(s1, s2);

        StringConcat concat3 = new StringConcat() {
            @Override
            public void makeString(String s1, String s2) {
                System.out.println(s1 + "," + s2);
            }
        };
        concat3.makeString(s1, s2);
    }
}
