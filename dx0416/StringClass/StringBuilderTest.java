package dx0416.StringClass;

public class StringBuilderTest {
    public static void main(String[] args) {
        String javaStr = new String("Java");
        System.out.println("javaStr 문자열 주소: " + System.identityHashCode(javaStr));

        StringBuilder buffer = new StringBuilder(javaStr);
        System.out.println("연산 전 buffer 메모리주소: " + System.identityHashCode(buffer));

        buffer.append(" and");
        buffer.append(" android");
        buffer.append(" programing is fun!!!");
        System.out.println("연산 후 buffer 메모리주소: " + System.identityHashCode(buffer));

        javaStr = buffer.toString();
        System.out.println(javaStr);
        System.out.println("새로 만들어진 javaStr 문자열 주소: " + System.identityHashCode(javaStr));
    }
}
