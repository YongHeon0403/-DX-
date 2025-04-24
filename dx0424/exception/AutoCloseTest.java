package dx0424.exception;

public class AutoCloseTest {
    public static void main(String[] args) {
        try(AutoCloseObj obj = new AutoCloseObj()) {
            throw new Exception();    // 강제로 예외를 발생시키는 메서드
        } catch (Exception e) {
            System.out.println("예외 부분입니다.");
        }
    }
}
